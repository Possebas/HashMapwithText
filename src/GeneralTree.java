import java.util.ArrayList;
import java.util.HashMap;

public class GeneralTree {

	// Classe interna Node
	private class Node {

		public Node father;
		public String element;
		public double terrace;
		public ArrayList<Node> subtrees;

		public Node(String element, double terrace) {
			father = null;
			this.element = element;
			this.terrace = terrace;
			subtrees = new ArrayList<>();
		}

		public void addSubtree(Node n) {
			n.father = this;
			subtrees.add(n);
		}

		public Node getSubtree(int i) {
			if ((i < 0) || (i >= subtrees.size())) {
				throw new IndexOutOfBoundsException();
			}
			return subtrees.get(i);
		}

		public int getSubtreesSize() {
			return this.subtrees.size();
		}

		public boolean isRoot() {
			if (father == null)
				return true;

			return false;
		}
	}

	// Atributos
	public Node root;
	private int count;
	public int terraceFather;

	public void setTerraceFather(int terraceFather) {
		this.terraceFather = terraceFather;
	}

	// Metodos
	public GeneralTree() {
		root = null;
		count = 0;
	}

	public boolean leaf(String nome) {
		Node n = searchNodeRef(nome, root);
		if (n != null) {
			return n.getSubtreesSize() == 0;
		}
		return false;
	}

	private ArrayList<Node> getLeaf() {
		ArrayList<Node> leaves = new ArrayList<Node>();
		getLeafReceiv(root, leaves);
		return leaves;
	}

	private void getLeafReceiv(Node n, ArrayList<Node> leaves) {
		if (n != null) {
			if (n.getSubtreesSize() == 0)
				leaves.add(n);
			else {
				for (int i = 0; i < n.getSubtreesSize(); i++) {
					getLeafReceiv(n.getSubtree(i), leaves);
				}

			}

		}
	}

	private Node searchNodeRef(String father, Node target) {
		Node res = null;
		if (target != null) {
			if (father.equals(target.element)) {
				res = target;
			} else {
				Node aux = null;
				int i = 0;
				while ((aux == null) && (i < target.getSubtreesSize())) {
					aux = searchNodeRef(father, target.getSubtree(i));
					i++;
				}
				res = aux;
			}
		}
		return res;
	}

	public void add(String root, TribeHashMap map, HashMap<String, Barbarian> warriors) {
		String father = root;
		ArrayList<String> Tribetree;
		Tribetree = map.get(father);
		if (Tribetree != null) {
			for (String s : Tribetree) {
				add(father,s, warriors.get(s).getTerrace());
			}
			Node aux = searchNodeRef(father, this.root);
			int qntChild = aux.getSubtreesSize();
			for (int i = 0; i < qntChild; i++) {
				add(aux.getSubtree(i).element, map, warriors);
			}
		}
	}

	public boolean add(String father, String element, double terrace) {
		Node n = new Node(element, terrace);
		Node nAux;
		boolean res = false;
		if (father == null) {
			if (root != null) {
				n.addSubtree(n);
				root.father = n;
			}
			root = n;
			res = true;
			count++;
		} else {
			nAux = searchNodeRef(father, root);
			if (nAux != null) {
				nAux.addSubtree(n);
				n.father = nAux;
				res = true;
				count++;
			}
		}
		return res;
	}

	private double calculaTerraRec(Node n, double terras) {
		if (n.isRoot())
			return terras + n.terrace / n.getSubtreesSize();
		else {
			return calculaTerraRec(n.father, (terras + (n.father.terrace / n.father.getSubtreesSize())));
		}
	}

	public double calculaTerra() {
		double maior = 0;
		ArrayList<Node> folhas = getLeaf();
		for (Node n : folhas) {
			double terras = n.terrace;
			terras = calculaTerraRec(n, terras);
			if (terras > maior)
				maior = terras;
		}
		return maior;
	}
}
	/**public ArrayList<String> positionsPre() {
		ArrayList<String> lista = new ArrayList<>();
		positionsPreAux(root, lista);
		return lista;
	}

	private void positionsPreAux(Node n, ArrayList <String> lista) {
		if (n != null) {
			lista.add(n.element);
			for (int i = 0; i < n.getSubtreesSize(); i++) {
				positionsPreAux(n.getSubtree(i), lista);
			}
		}
	}
*/
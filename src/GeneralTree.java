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

	// Metodos
	public GeneralTree() {
		root = null;
		count = 0;
	}

	public boolean leaf(String name) {
		Node n = searchNodeRef(name, root);
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

	public void add(String root, TribeHashMap map, HashMap<String, Barbarian> guerreiros) {
		String father = root;
		ArrayList<String> Tribetree;
		Tribetree = map.get(father);
		if (Tribetree != null) {
			for (String s : Tribetree) {
				add(father,s, guerreiros.get(s).getTerrace());
			}

			Node aux = searchNodeRef(father, this.root);
			int qntChild = aux.getSubtreesSize();
			for (int i = 0; i < qntChild; i++) {
				add(aux.getSubtree(i).element, map, guerreiros);
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

	private double terraRecebida(Node n, double terraceRcv) {
		if (n.isRoot())
			return terraceRcv + n.terrace / n.getSubtreesSize();
		else {
			return terraRecebida(n.father, (terraceRcv + (n.father.terrace / n.father.getSubtreesSize())));
		}
	}

	public double calculaTerra()
	{
		double maior = 0;
		ArrayList<Node> nodofolha = getNodosFolhas();
		for(Node n: nodofolha) {
			double terraceRec = n.terrace;
			terraceRec = terraRecebida(n, terraceRec);
			if(terraceRec > maior)
				maior = terraceRec;
		}
		return maior;
	}

	private ArrayList<Node> getNodosFolhas()
	{
		ArrayList<Node> nleaf = new ArrayList<Node>();
		getFolhaRecebido(root, nleaf);
		return nleaf;
	}

	private void getFolhaRecebido(Node n, ArrayList<Node> nodeLeaf) {
		if (n != null ){
			if (n.getSubtreesSize() == 0)
				nodeLeaf.add(n);
			else {
				for(int i=0; i<n.getSubtreesSize(); i++) {
					getFolhaRecebido(n.getSubtree(i), nodeLeaf);
				}
			}
		}

	}

	public ArrayList<String> positionsPre() {
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
}
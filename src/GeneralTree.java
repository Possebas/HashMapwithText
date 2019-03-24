import java.util.ArrayList;
import java.util.LinkedList;

public class GeneralTree {

	// Classe interna Node
	private class Node {

		public Node father;
		public String element;
		public int terrace;
		public ArrayList<Node> subtrees;

		public Node(String element, int terrace) {
			father = null;
			this.element = element;
			this.terrace = terrace;
			subtrees = new ArrayList<>();
		}

		public Node(Node father,String element, int terrace) {
			this.father = father;
			this.element = element;
			this.terrace = terrace;
			subtrees = new ArrayList<>();
		}

		public void addSubtree(Node n) {
			n.father = this;
			//String child = n.element;
			subtrees.add(n);
		}

		public boolean removeSubtree(Node n) {
			n.father = null;
			//String child = n.element;
			return subtrees.remove(n);
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

		public void setTerrace(int terrace) {
			this.terrace = terrace;
		}

		public int getTerrace() {
			return this.terrace;
		}
}
	// Atributos
	public Node root;
	private int count;
	public int terraceFather;


	public int getTerraceFather() {
		return terraceFather;
	}

	public void setTerraceFather(int terraceFather) {
		this.terraceFather = terraceFather;
	}

	// Metodos
	public GeneralTree() {
		root = null;
		count = 0;
	}

	public String getRoot() {
		if (isEmpty()) {
			throw new EmptyTreeException("GetRoot failure");
		}
		return root.element;
	}
	public void setRoot(String element) {
		if (isEmpty()) {
			throw new EmptyTreeException("SetRoot failure");
		}
		root.element = element;
	}

	public boolean isRoot(String element) {
		if (root != null) {
			if (root.element.equals(element)) {
				return true;
			}
		}
		return false;
	}

	public boolean isEmpty() {
		return (root == null);
	}

	public int size() {
		return count;
	}

	public void clear() {
		root = null;
		count = 0;
	}

	public String getFather(String element) {
		Node n = searchNodeRef(element, root);
		if (n == null || n.father == null) {
			return null;
		} else {
			return n.father.element;
		}
	}

	public boolean contains(String element) {
		Node nAux = searchNodeRef(element, root);
		return (nAux != null);
	}

	private Node searchNodeRef(String element, Node target) {
		Node res = null;
		if (target != null) {
			if (element.equals(target.element)) {
				res = target;
			} else {
				Node aux = null;
				int i = 0;
				while ((aux == null) && (i < target.getSubtreesSize())) {
					aux = searchNodeRef(element, target.getSubtree(i));
					i++;
				}
				res = aux;
			}
		}
		return res;
	}

	public void add(String father, String element, int terrace) {
        Node n = new Node(element,terrace);
        Node nAux;
        if(root == null){
        	Node nPatrono = new Node(father,0);
        	nPatrono.addSubtree(n);
        	root = nPatrono;
        } else {
        	nAux = searchNodeRef(father, root);
        	if (nAux != null){
        		nAux.addSubtree(n);
	        }
        }
        count++;
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

//	public LinkedList<Node> listChild() {
//		listChildAux(root, list);
//		return list;
//	}
//
//	private void listChildAux(Node n, LinkedList<Node> list) {
//		if (n != null) {
//			list.add(n);
//			for (int i = 0; i < n.getSubtreesSize(); i++) {
//				listChildAux(n.getSubtree(i), list);
//			}
//		}
//	}

//	public ArrayList<String> positionsWidth() {
//		ArrayList<String> lista = new ArrayList<>();
//
//		QueueM<Node> fila = new QueueM<>();
//		Node atual = null;
//
//		if (root != null) {
//			fila.enqueue(root);
//			while (!fila.isEmpty()) {
//				atual = fila.dequeue();
//				lista.add(atual.element);
//				for (int i = 0; i < atual.getSubtreesSize(); i++) {
//					fila.enqueue(atual.getSubtree(i));
//				}
//			}
//		}
//		return lista;
//	}

}
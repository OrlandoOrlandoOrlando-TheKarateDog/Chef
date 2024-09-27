package menu;

public class BinaryTree<T> {
	private Node root;
	
	class Node {
		int key;
		T value;
		Node left, right;
		
		Node(T value) {
			this.value = value;
			key = value.hashCode();
		}
		
	}
	
	public void insert(T value) {
		if (root == null)
			root = new Node(value);
		else
			insert(root, new Node(value));
	}
	
	void insert(Node stem, Node leaf) {
		// equal keys are biased leftward
		if (stem.key <= leaf.key)
			if (stem.left == null)
				stem.left = leaf;
			else
				insert(stem.left, leaf);
		else
			if (stem.right == null)
				stem.right = leaf;
			else
				insert(stem.right, leaf);
	}
	
	public boolean search(T value) {
		if (root == null)
			return false;
		
		return search(root, value.hashCode());
	}
	
	public boolean search(Node stem, int key) {
		if (stem == null)
			return false;
		
		// keys may collide
		if (stem.key == key)
			return true;
		
		if (stem.key < key)
			return search(stem.left, key);
		else
			return search(stem.right, key);
	}

}

import java.util.*;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	private TreeNode<String> root;

	/**
	 * constructor
	 */
	public MorseCodeTree() {
		root = new TreeNode<String>("");
		buildTree();
	}

	/**
	 * hardcode building of morse tree
	 */
	public void buildTree() {

		// row 2
		insert(".", "e");
		insert("-", "t");

		// row3
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");

		// row4
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");

		// row 5
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

	/**
	 * calls add node w param code and letter, both string
	 */
	public void insert(String code, String letter) {
		addNode(root, code, letter);
	}

	/**
	 * @return node
	 */
	public TreeNode<String> getRoot() {
		return root;
	}

	/**
	 * sets root
	 */
	public void setRoot(TreeNode<String> newRoot) {
		this.root = newRoot;
	}

	/**
	 * recurrsively adds node
	 */
	public void addNode(TreeNode<String> root, String code, String letter) {
		// base case
		if (code.length() == 1) {
			if (code.equals(".")) {
				// adds to left
				root.setChildL(new TreeNode<>(letter));
			} else {
				// adds to right
				root.setChildR(new TreeNode<>(letter));
			}
			return;
		}

		// directs to the left path
		if (code.charAt(0) == '.') {
			if (root.getChildL() == null) {
				// adds child if it is null
				root.setChildL(new TreeNode<>(""));
			}
			// recursive line
			addNode(root.getChildL(), code.substring(1), letter);
		} else {

			// in case of right path does the same thing as right
			if (root.getChildR() == null) {
				root.setChildR(new TreeNode<>(""));
			}
			addNode(root.getChildR(), code.substring(1), letter);
		}
	}

	/**
	 * calls fetch node
	 */
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	/**
	 * recursively searches for node
	 */
	public String fetchNode(TreeNode<String> root, String code) {
		if (root == null) {
			return "";
		}
		// base case
		if (code.length() == 0) {
			return root.getData();
		}
		// Recursive case
		if (code.charAt(0) == '.') {
			return fetchNode(root.getChildL(), code.substring(1));
		} else {
			return fetchNode(root.getChildR(), code.substring(1));
		}
	}

	/**
	 * unsupported
	 */
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * unsupported
	 */
	public MorseCodeTree update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * traverses to make into arraylist
	 */
	public ArrayList<String> toArrayList() {
		ArrayList<String> arr = new ArrayList<>();
		LNRoutputTraversal(root, arr);
		return arr;
	}

	/**
	 * recursively traverses
	 */
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> arr) {
		if (root != null) {
			// bottom left first
			LNRoutputTraversal(root.getChildL(), arr);
			// root next
			arr.add(root.getData());
			// right last
			LNRoutputTraversal(root.getChildR(), arr);
		}
	}
}

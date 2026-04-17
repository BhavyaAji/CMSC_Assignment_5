/**
 * tree node class
 * 
 * @param <T>
 */
public class TreeNode<T> {
	private T data;
	private TreeNode<T> childL;
	private TreeNode<T> childR;

	/**
	 * 
	 * @param data
	 */
	public TreeNode(T data) {
		this.data = data;
		childL = null;
		childR = null;
	}

	/**
	 * 
	 * @param node
	 */
	public TreeNode(TreeNode<T> node) {
		if (node == null) {
			return;
		}
		this.data = node.data;

		if (node.childL != null) {
			this.childL = new TreeNode<>(node.childL);
		} else {
			this.childL = null;
		}

		if (node.childR != null) {
			this.childR = new TreeNode<>(node.childR);
		} else {
			this.childR = null;
		}
	}

	/**
	 * 
	 * @return data
	 */
	public T getData() {
		return data;
	}

	/**
	 * 
	 * @return node
	 */
	public TreeNode<T> getChildL() {
		return childL;
	}

	/**
	 * 
	 * @return node
	 */
	public TreeNode<T> getChildR() {
		return childR;
	}

	/**
	 * 
	 * @param data
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * 
	 * @param childL
	 */
	public void setChildL(TreeNode<T> childL) {
		this.childL = childL;
	}

	/**
	 * 
	 * @param childR
	 */
	public void setChildR(TreeNode<T> childR) {
		this.childR = childR;
	}
}

import org.junit.platform.engine.support.hierarchical.Node;

public class TreeNode<T> {
	
	protected T tree;
	protected TreeNode<T> left, right;
	
	public TreeNode(T dataNode) {
		this.tree = dataNode;
		this.left = this.right = null;
	}

	public TreeNode(TreeNode<T> node) {
		new TreeNode<T>(node);
	}

	public T getData() {
		return (T) this.tree;
		
	}

}

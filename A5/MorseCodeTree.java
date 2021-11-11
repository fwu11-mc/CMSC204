import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

	private TreeNode<String> root;
	
	public MorseCodeTree() {
		buildTree();
	}
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		this.root = newNode;
	}

	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) {
		addNode(root, code, result);
		return this;
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if (code.length()==1) {
			if (code.equals(".")) {
				root.left = new TreeNode<>(letter);
			}
			else {
				root.right = new TreeNode<>(letter);
			}
		}
		else {
			if (code.charAt(0) == '.') {
				addNode(root.left, code.substring(1), letter);
			}
			else {
				addNode(root.right, code.substring(1), letter);
			}
		}
	}

	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		String letter;
		if (code.length()<=1) {
			if (code.equals(".")) {
				return root.left.tree;
			}
			else {
				return root.right.tree;
			}
		}
		else {
			if (code.charAt(0)=='.') {
				letter = fetchNode(root.left, code.substring(1));
			}else {
				letter = fetchNode(root.right, code.substring(1));
			}
		}
		return letter;
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void buildTree() {
	    root = new TreeNode<String>("");

	    insert(".", "e");
	    insert("-", "t");

	    insert("..", "i");
	    insert(".-", "a");
	    insert("-.", "n");
	    insert("--", "m");

	    insert("...", "s");
	    insert("..-", "u");
	    insert(".-.", "r");
	    insert(".--", "w");
	    insert("-..", "d");
	    insert("-.-", "k");
	    insert("--.", "g");
	    insert("---", "o");

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

	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> List = new ArrayList<>();
		LNRoutputTraversal(root, List);

		return List;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root.left != null) {
			LNRoutputTraversal(root.left, list);
		}
		list.add(root.tree);
		if (root.right != null) {
			LNRoutputTraversal(root.right, list);
		}
	}
	public ArrayList<String> toArrayList1() {
		// TODO Auto-generated method stub
		return null;
	}


}

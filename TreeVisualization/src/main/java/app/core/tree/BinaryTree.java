package main.java.app.core.tree;
import main.java.app.core.Node;
import java.util.List;
import java.util.ArrayList;
public class BinaryTree {
	public Node root;
	//==========================
	//INSERT
	//==========================
	public void insert(int value) {		
		root = insertRec(root, value);
	}
	private Node insertRec(Node node, int value) {
		if (node == null) return new Node(value);	//root is a leaf or empty tree
		else if (node.value > value) {
			node.left = insertRec(node.left, value);
		}
		else {
			node.right = insertRec(node.right,value);
		}
		return node;
	}
	//==========================
	//SEARCH
	//==========================
	public Node search(int value) {
		return searchRec(root, value);
	}
	private Node searchRec(Node node, int value) {
		if(node == null || node.value == value) return node;
		else if(value < node.value) return searchRec(node.left,value);
		else return searchRec(node.right,value);
	}
	//==========================
	//INORDER TRAVERSAL
	//==========================
	public List<Node> inOrder(){
		List<Node> result = new ArrayList<>();
		inOrderRec(root,result);
		return result;
	}
	private void inOrderRec(Node node, List<Node> result){
		if(node == null) return;
		inOrderRec(node.left,result);
		result.add(node);
		inOrderRec(node.right,result);
	}
	//==========================
	//PREORDER TRAVERSAL
	//==========================
	public List<Node> preOrder(){
		List<Node> result = new ArrayList<>();
		preOrderRec(root,result);
		return result;
	}
	private void preOrderRec(Node node, List<Node> result){
		if(node == null) return;
		result.add(node);
		preOrderRec(node.left,result);
		preOrderRec(node.right,result);
	}
	//==========================
	//POSTORDER TRAVERSAL
	//==========================
	public List<Node> postOrder(){
		List<Node> result = new ArrayList<>();
		postOrderRec(root,result);
		return result;
	}
	private	 void postOrderRec(Node node, List<Node> result){
		if(node == null) return;
		postOrderRec(node.left,result);
		postOrderRec(node.right,result);
		result.add(node);
	}
}

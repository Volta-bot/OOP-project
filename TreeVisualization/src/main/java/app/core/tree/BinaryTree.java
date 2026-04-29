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
}

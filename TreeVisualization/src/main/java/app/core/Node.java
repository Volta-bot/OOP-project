package main.java.app.core;
import java.util.List;
import java.util.ArrayList;
public class Node {
	public int value;
	
	// Binary tree
	public Node left;
	public Node right;
	
	// Generic tree
	public List<Node> children; 
	
	// Red Black Tree
	public boolean isRed;
	
	// Constructor
	public Node(int value) {
		this.value = value;
		this.children = new ArrayList<>();
		this.isRed = true;
	}
}

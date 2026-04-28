package main.java.app.algorithm;
import main.java.app.core.Node;
public class Step {
	public String description;
	public Node node;
	
	public Step(String description, Node node) {
		this.node = node;
		this.description = description;
	}
}

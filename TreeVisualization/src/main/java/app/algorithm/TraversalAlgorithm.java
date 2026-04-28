package main.java.app.algorithm;
import main.java.app.core.Node;
import main.java.app.algorithm.Step;
import java.util.List;
import java.util.ArrayList;
public class TraversalAlgorithm {
	public List<Step> inOrderSteps(Node root){	// returns a list of steps
		List<Step> steps = new ArrayList<>();
		inOrderStepsRec(root, steps);
		return steps;
	}
	private void inOrderStepsRec(Node node, List<Step> steps){
		if (node == null) return;
		inOrderStepsRec(node.left, steps);
		steps.add(new Step("Visit" + node.value, node));
		inOrderStepsRec(node.right, steps);
	}
}

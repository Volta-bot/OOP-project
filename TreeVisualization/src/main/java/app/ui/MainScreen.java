package main.java.app.ui;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import main.java.app.core.Node;
import main.java.app.core.tree.*;
import main.java.app.algorithm.*;

import java.util.List;
public class MainScreen {
	private Pane canvas = new Pane();
	private Label label = new Label("Ready");
	private Button button = new Button("Run Inorder");

	private BinaryTree tree = new BinaryTree();
	private TraversalAlgorithm algo = new TraversalAlgorithm();
    
	public MainScreen() {
        // Hardcoded tree
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(7);

		drawTree(); // initial draw

		button.setOnAction(e -> runTraversal());
    }

	public BorderPane getRoot() {
		BorderPane root = new BorderPane();
		root.setCenter(canvas);
		root.setBottom(label);
		root.setTop(button);
		return root;
    }
    private void drawTree() {
        canvas.getChildren().clear();
        drawNode(tree.root, 400, 50, 200);
    }

    private void drawNode(Node node, double x, double y, double offset) {
        if (node == null) return;

        javafx.scene.shape.Circle circle = new javafx.scene.shape.Circle(x, y, 15);
        javafx.scene.text.Text text = new javafx.scene.text.Text(x - 5, y + 5, String.valueOf(node.value));
        canvas.getChildren().addAll(circle, text);

        if (node.left != null) {
            canvas.getChildren().add(new javafx.scene.shape.Line(x, y, x - offset, y + 70));
            drawNode(node.left, x - offset, y + 70, offset / 2);
        }
        if (node.right != null) {
            canvas.getChildren().add(new javafx.scene.shape.Line(x, y, x + offset, y + 70));
            drawNode(node.right, x + offset, y + 70, offset / 2);
        }
    }
    private void runTraversal() {
        List<Step> steps = algo.inOrderSteps(tree.root);

        new Thread(() -> {
            for (Step step : steps) {
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {}

                javafx.application.Platform.runLater(() -> {
                    label.setText(step.description);
                    highlight(step.node);
                });
            }
        }).start();
    }
    private void highlight(Node target) {
        drawTree();
        highlightRec(tree.root, target, 400, 50, 200);
    }

    private void highlightRec(Node node, Node target, double x, double y, double offset) {
        if (node == null) return;

        if (node == target) {
            javafx.scene.shape.Circle circle = new javafx.scene.shape.Circle(x, y, 18);
            circle.setStyle("-fx-fill: red;");
            canvas.getChildren().add(circle);
        }
        highlightRec(node.left, target, x - offset, y + 70, offset / 2);
        highlightRec(node.right, target, x + offset, y + 70, offset / 2);
    }
}

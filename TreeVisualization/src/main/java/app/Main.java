package main.java.app;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import main.java.app.ui.MainScreen;
public class Main extends Application {
	@Override
    public void start(Stage stage) {

        MainScreen screen = new MainScreen();

        Scene scene = new Scene(screen.getRoot(), 800, 600);

        stage.setTitle("Tree Visualization");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

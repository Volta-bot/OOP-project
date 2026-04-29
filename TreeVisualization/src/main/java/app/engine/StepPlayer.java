package main.java.app.engine;
import main.java.app.algorithm.Step;
import javafx.application.Platform;

import java.util.List;
import java.util.function.Consumer;
public class StepPlayer {
	private int delay = 1000; //in milliseconds
	public void play(List<Step> steps, Consumer<Step> onStep) {
		new Thread(() -> {
			for (Step step : steps) {
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Platform.runLater(() -> {onStep.accept(step);});
            }
        }).start();
	}
}

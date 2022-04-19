package UI;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BuySmallPaneApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
    	String viewFileName = "buySmallPane.fxml";
    	String windowTite = "Buy Window";
        Parent root = FXMLLoader.load(getClass().getResource(viewFileName));
        stage.setTitle(windowTite);
        stage.setScene(new Scene(root, 660, 207));
        stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BuyBigPaneApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
    	String viewFileName = "buyBigPane.fxml";
    	String windowTite = "Buy Window";
        Parent root = FXMLLoader.load(getClass().getResource(viewFileName));
        stage.setTitle(windowTite);
        stage.setScene(new Scene(root, 640, 750));
        stage.setResizable(false);
        stage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}
}

package UI;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SellerMainApp extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		String viewFileName = "SellerMainPane.fxml";
    	String windowTite = "Seller UI Window";
        Parent root = FXMLLoader.load(getClass().getResource(viewFileName));
        stage.setTitle(windowTite);
        stage.setScene(new Scene(root, 735, 515));
        stage.setResizable(false);
        stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}

package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegistrationCancelApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
    	String viewFileName = "/UI/registrationCanelPane.fxml";
    	String windowTite = "Alert";
        Parent root = FXMLLoader.load(getClass().getResource(viewFileName));
        stage.setTitle(windowTite);
        stage.setScene(new Scene(root, 450, 150));
        
        stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

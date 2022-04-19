package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DealsOnHoldApp extends Application {

    public void start(Stage stage) throws Exception {
    	String viewFileName = "dealsOnHoldPane.fxml";
    	String windowTite = "Deals on hold Window";
        Parent root = FXMLLoader.load(getClass().getResource(viewFileName));
        stage.setTitle(windowTite);
        stage.setScene(new Scene(root, 679, 496));
        stage.show();
    }


	public static void main(String[] args) {
		launch(args);
	}
}

package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DealsOnHoldApp extends Application {

	@Override
    public void start(Stage stage) throws Exception {
    	String viewFileName = "dealsOnHoldPane.fxml";
    	String windowTite = "Deals On Hold Window";
        Parent root = FXMLLoader.load(getClass().getResource(viewFileName));
        stage.setTitle(windowTite);
        stage.setScene(new Scene(root, 650, 520));
        stage.setResizable(false);
        stage.show();
    }

	public static void main(String[] args) {
		launch(args);
	}
}

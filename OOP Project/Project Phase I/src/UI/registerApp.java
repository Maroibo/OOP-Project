package UI;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class registerApp extends Application {
	@Override
	public void start(Stage stage) throws Exception {
    	String viewFileName = "registrationPane.fxml";
    	String windowTite = "Registration Widonow";
        Parent root = FXMLLoader.load(getClass().getResource(viewFileName));
        stage.setTitle(windowTite);
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

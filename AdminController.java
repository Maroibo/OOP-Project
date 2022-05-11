package UI;

import java.io.IOException;
import java.util.Optional;

import files.ReaderAndWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class AdminController {

    @FXML
    private Button clearHistoryButton;

    @FXML
    private Button logoutButton;

    @FXML
    void onClearHistoryClick(ActionEvent event) throws ClassNotFoundException, IOException {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Panel");
        alert.setHeaderText("Are you sure you want to clear the history?");
        alert.setContentText("This button clears all the logged users\nand removes all the data stored");
        Optional<ButtonType> result=alert.showAndWait();
        if(result.isPresent()&&result.get()==ButtonType.OK) {
        	ReaderAndWriter.reset();
        }
    }

    @FXML
    void onLogoutClick(ActionEvent event) throws IOException {
    	ReaderAndWriter.removeLog();
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("loginPane.fxml"));
            Stage stage = (Stage) logoutButton.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }

}

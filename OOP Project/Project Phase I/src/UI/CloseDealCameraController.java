package UI;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CloseDealCameraController {

    @FXML
    private TextField CameraBrandTextField;

    @FXML
    private TextField CameraColourTextField;

    @FXML
    private TextField CameraIdTextField;

    @FXML
    private TextField CameraLensSizeTextField;

    @FXML
    private TextField CameraPixelSizeTextField;

    @FXML
    private TextField CameraPriceTextField;

    @FXML
    private TextField CameraZoomTextField;

    @FXML
    private Button cancelButton;

    @FXML
    private Button closeDealButton;

    @FXML
    void onCancelClick(ActionEvent event) {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SellerMainPane.fxml"));
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }

    @FXML
    void onCloseDealClick(ActionEvent event) {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Confirmation Panel");
    	alert.setHeaderText("Are you sure you want to close this deal?");
    	alert.setContentText("Item info:");
    	Optional<ButtonType> result=alert.showAndWait();
    	if(result.isPresent()&&result.get()==ButtonType.OK) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("SellerMainPane.fxml"));
                Stage stage = (Stage) closeDealButton.getScene().getWindow();
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
            }catch (IOException io){
                io.printStackTrace();
            }
    	}
    }

}

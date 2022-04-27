package UI;

import java.io.IOException;
import java.util.Optional;

import eQatarSystem.Camera;
import eQatarSystem.Electronic;
import eQatarSystem.Trader;
import files.ReaderAndWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class UpdateCameraController{

    @FXML
    TextField CameraBrandTextField;

    @FXML
    TextField CameraColourTextField;

    @FXML
    TextField CameraIdTextField;

    @FXML
    TextField CameraLensSizeTextField;

    @FXML
     TextField CameraPixelSizeTextField;

    @FXML
     TextField CameraPriceTextField;

    @FXML
     TextField CameraZoomTextField;

    @FXML
    private Button cancelButton;

    @FXML
    private Button saveButton;
     private Camera c1;

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
    void onSaveClick(ActionEvent event) throws ClassNotFoundException, IOException {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Confirmation Panel");
    	alert.setHeaderText("Are you sure you want to save changes?");
    	alert.setContentText("Item info: "+c1.toString());
    	Optional<ButtonType> result=alert.showAndWait();
    	if(result.isPresent()&&result.get()==ButtonType.OK) {
        	c1.setBrand(CameraBrandTextField.getText());
        	c1.setColor(CameraColourTextField.getText());
        	c1.setLensSize(CameraLensSizeTextField.getText());
        	c1.setPixelSize(CameraPixelSizeTextField.getText());
        	c1.setPrice(Double.parseDouble(CameraPriceTextField.getText()));
        	c1.setZoom(CameraZoomTextField.getText());
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SellerMainPane.fxml"));    
	        Parent root = (Parent)fxmlLoader.load();          
	        SellerMainController sellerController = fxmlLoader.getController();
            Trader t1=ReaderAndWriter.getLog();
            t1.modifyProperties(c1);
            ReaderAndWriter.currentLog(t1);
            ReaderAndWriter.refresh();
            ObservableList<Electronic> list=FXCollections.observableArrayList(ReaderAndWriter.getLog().getList());
            sellerController.itemsTable.setItems(list);
            try {
                FXMLLoader loader1 = new FXMLLoader(getClass().getResource("SellerMainPane.fxml"));
                Stage stage = (Stage) saveButton.getScene().getWindow();
                Scene scene = new Scene(loader1.load());
                stage.setScene(scene);
            }catch (IOException io){
                io.printStackTrace();
            }
    	}
    }
    @FXML
    void setSelected(Electronic c) {
    	this.c1=(Camera)c;
    }
    @FXML
    Camera getSelected() {
    	return this.c1;
    }
}

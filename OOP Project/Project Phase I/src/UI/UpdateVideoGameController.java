package UI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import eQatarSystem.Electronic;
import eQatarSystem.Smartphone;
import eQatarSystem.Trader;
import eQatarSystem.VideoGame;
import files.ReaderAndWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class UpdateVideoGameController {

    @FXML
    TextField VideoGameBrandTextField;

    @FXML
     TextField VideoGameColourTextField;

    @FXML
     TextField VideoGameConnectivityTextField;

    @FXML
     TextField VideoGameControllerTextField;

    @FXML
     TextField VideoGameDimensionsTextField;

    @FXML
     TextField VideoGameDisplayTextField;

    @FXML
     TextField VideoGameIdTextField;

    @FXML
     TextField VideoGameMemoryTextField;

    @FXML
     TextField VideoGamePriceTextField;

    @FXML
    private Button cancelButton;

    @FXML
    private Button saveButton;
    private VideoGame c1;

    @FXML
    void onCancelClick(ActionEvent event) {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SellerMainPane.fxml"));
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException io){
            io.printStackTrace();
        }
    }

    @FXML
    void onSaveClick(ActionEvent event) throws IOException, ClassNotFoundException {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Confirmation Panel");
    	alert.setHeaderText("Are you sure you want to save changes?");
    	alert.setContentText("Item info: "+c1.toString());
    	Optional<ButtonType> result=alert.showAndWait();
    	if(result.isPresent()&&result.get()==ButtonType.OK) {
        	c1.setBrand(VideoGameBrandTextField.getText());
        	c1.setColor(VideoGameColourTextField.getText());
        	c1.setDimensions(VideoGameDimensionsTextField.getText());
        	c1.setMemory(VideoGameMemoryTextField.getText());
        	c1.setPrice(Double.parseDouble(VideoGamePriceTextField.getText()));
        	c1.setConnectivity(VideoGameConnectivityTextField.getText());
        	c1.setController(VideoGameControllerTextField.getText());
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SellerMainPane.fxml"));    
	        Parent root = (Parent)fxmlLoader.load();          
	        SellerMainController sellerController = fxmlLoader.getController();
            Trader t1=ReaderAndWriter.getLog();
            t1.modifyProperties(c1);
            ReaderAndWriter.currentLog(t1);
            ReaderAndWriter.refresh();
            ArrayList<Electronic> electronics=ReaderAndWriter.e;
            int count=0;
            for(Electronic e: electronics) {
            	if(c1.getId()==e.getId())
            		electronics.set(count, c1);
            	count++;
            }ReaderAndWriter.setE(electronics);
            ArrayList<Trader> traders=ReaderAndWriter.t;
             count=0;
            for(Trader t: traders) {
            	if(t1.getId()==t.getId())
            		traders.set(count, t1);
            	count++;
            }ReaderAndWriter.setT(traders);
            ReaderAndWriter.save();
            ReaderAndWriter.refresh();
            ObservableList<Electronic> list=FXCollections.observableArrayList(ReaderAndWriter.getLog().getList());
            sellerController.itemsTable.setItems(list);
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("SellerMainPane.fxml"));
                Stage stage = (Stage) saveButton.getScene().getWindow();
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
            }catch (IOException io){
                io.printStackTrace();
            }
    	}
    }
    @FXML
    void setSelected(Electronic c) {
    	this.c1=(VideoGame)c;
    }
    @FXML
    VideoGame getSelected() {
    	return this.c1;
    }
}
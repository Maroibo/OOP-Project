package UI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import eQatarSystem.Deal;
import eQatarSystem.Electronic;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CloseDealVideoGameController {

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
    private Button closeDealButton;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private VideoGame c1;

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
    void onCloseDealClick(ActionEvent event) throws ClassNotFoundException, IOException {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Confirmation Panel");
    	alert.setHeaderText("Are you sure you want to close this deal?");
    	alert.setContentText("Item info:");
    	Optional<ButtonType> result=alert.showAndWait();
    	if(result.isPresent()&&result.get()==ButtonType.OK) {
    		ArrayList<Deal> list=ReaderAndWriter.getDealsOnHold(ReaderAndWriter.getLog());
    		for(Deal d: list) {
    			if(d.getElectronicItem().getId()==c1.getId()) {
    				d.getElectronicItem().setSold(true);
    				d.setClosed(true);
    				int count=0;
    				for(Deal deal: ReaderAndWriter.d) {
    					if(deal.getDealNo()==d.getDealNo())
    						ReaderAndWriter.d.set(count, d);
    					count++;
    				}
    				count=0;
    				for(Electronic e:ReaderAndWriter.getLog().getList()) {
    					if(e.getId()==d.getElectronicItem().getId()) {
    						ReaderAndWriter.getLog().getList().set(count, d.getElectronicItem());
    						ReaderAndWriter.save();}
    						count++;	
    				}
    				ReaderAndWriter.save();
    				}
    				}
    		}
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SellerMainPane.fxml"));    
	        Parent root = (Parent)fxmlLoader.load();          
	        SellerMainController sellerController = fxmlLoader.getController();
	        ReaderAndWriter.refresh();
    		ObservableList<Electronic> e=FXCollections.observableArrayList(ReaderAndWriter.getLog().getList());
            sellerController.itemsTable.setItems(e);
        	Alert alert1=new Alert(AlertType.CONFIRMATION);
        	alert1.setTitle("Congratulations Panel");
        	alert1.setHeaderText("Sucsess!");
        	alert1.setContentText("�Success! A deal was closed. Please click save to update the list of available items for sale");
        	Optional<ButtonType> result1=alert1.showAndWait();
        	if(result1.isPresent()&&result1.get()==ButtonType.OK) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("SellerMainPane.fxml"));
                Stage stage = (Stage) closeDealButton.getScene().getWindow();
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
            }catch (IOException io){
                io.printStackTrace();
            }
    	}}
    @FXML
    void setSelected(Electronic c) {
    	this.c1=(VideoGame)c;
    }
    @FXML
    VideoGame getSelected() {
    	return this.c1;
    }}
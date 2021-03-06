package UI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import eQatarSystem.Camera;
import eQatarSystem.Electronic;
import eQatarSystem.Smartphone;
import eQatarSystem.Trader;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class UpdateSmartphoneController {

    @FXML
    private Button cancelButton;

    @FXML
    private Button saveButton;

    @FXML TextField smartphoneBrandTextField;

    @FXML TextField smartphoneCamResTextField;

    @FXML TextField smartphoneColourTextField;

    @FXML TextField smartphoneIdTextField;

    @FXML TextField smartphonePriceTextField;

    @FXML TextField smartphoneScreenSizeTextField;

    @FXML
    ComboBox<String> smartphoneStorageComboBox;
    private Smartphone c1;
    private Smartphone show;
    
    public Smartphone getShow() {
		return show;
	}

	public void setShow(Smartphone show) {
		this.show = show;
	}

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
    void onSaveClick(ActionEvent event) throws IOException, ClassNotFoundException {
    	int id= Integer.parseInt(smartphoneIdTextField.getText());
    	String brand=smartphoneBrandTextField.getText();
    	String color=smartphoneColourTextField.getText();
    	String screen=smartphoneScreenSizeTextField.getText();
    	String cameras=smartphoneCamResTextField.getText();
    	double price=Double.parseDouble(smartphonePriceTextField.getText());
    	String storage=smartphoneStorageComboBox.getValue();
    	Smartphone smart=new Smartphone(id,price,brand,color,storage,screen,cameras);
    	this.setShow(smart);
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Confirmation Panel");
    	alert.setHeaderText("Are you sure you want to save changes?");
    	alert.setContentText("Item info: "+show.toString());
    	Optional<ButtonType> result=alert.showAndWait();
    	if(result.isPresent()&&result.get()==ButtonType.OK) {
        	c1.setBrand(smartphoneBrandTextField.getText());
        	c1.setColor(smartphoneColourTextField.getText());
        	c1.setPrice(Double.parseDouble(smartphonePriceTextField.getText()));
        	c1.setCameraResolution(smartphoneCamResTextField.getText());
        	c1.setScreenSize(smartphoneScreenSizeTextField.getText());
        	c1.setStorage(smartphoneStorageComboBox.getValue());
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
    public void initialize() {
        smartphoneStorageComboBox.getItems().removeAll(smartphoneStorageComboBox.getItems());
        smartphoneStorageComboBox.getItems().addAll("16GB", "32GB", "64GB", "128GB", "256GB", "512GB", "1TB");
    }
    @FXML
    void setSelected(Electronic c) {
    	this.c1=(Smartphone)c;
    }
    @FXML
    Smartphone getSelected() {
    	return this.c1;
    }
    @FXML
    void inputValidation1(KeyEvent event) {
    	smartphonePriceTextField.setTextFormatter(new TextFormatter<>(c -> {
    	    if (!c.getControlNewText().matches("\\d*")) 
    	        return null;
    	    else
    	        return c;
    	    }
    	));
    }

    @FXML
    void inputValidaton(KeyEvent event) {
    	smartphoneIdTextField.setTextFormatter(new TextFormatter<>(c -> {
    	    if (!c.getControlNewText().matches("\\d*")) 
    	        return null;
    	    else
    	        return c;
    	    }
    	));
    }
}
package UI;

import java.io.IOException;
import java.util.Optional;

import eQatarSystem.Trader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;
import files.*;

public class RegisterController {

    @FXML
    private TextField adressTextField;
    @FXML
    private Button cancelButton;


    @FXML
    private TextField idTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private ComboBox<String> traderTypeComboBox;
    
    @FXML
    private Button submitButton;

    @FXML
    void onCanelClick(ActionEvent event) {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Canelation Panel");
    	alert.setHeaderText("Are you sure?");
    	alert.setContentText("Are you sure you want to cancel this form?");
    	Optional<ButtonType> result=alert.showAndWait();
    	if(result.isPresent()&&result.get()==ButtonType.OK) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("mainPane.fxml"));
                Stage stage = (Stage) cancelButton.getScene().getWindow();
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
            }catch (IOException io){
                io.printStackTrace();
            }
    	}
    	
    }
    @FXML
    void onSubmitClicked(ActionEvent event) throws ClassNotFoundException {
    	String name=nameTextField.getText();
    	int id=Integer.parseInt(idTextField.getText());
    	int phone=Integer.parseInt(phoneTextField.getText());
    	String adress=adressTextField.getText();
    	if(traderTypeComboBox.getValue().equals("Buyer")) {
    		Trader t1=new Trader(id,name,false,true,phone,adress);
        	try {
        		ReaderAndWriter.refresh();
    			ReaderAndWriter.twrite(t1);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("BuyerMainPane.fxml"));
                Stage stage = (Stage) submitButton.getScene().getWindow();
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
            }catch (IOException io){
                io.printStackTrace();
            }
    	}if(traderTypeComboBox.getValue().equals("Seller")) {
    		Trader t1=new Trader(id,name,true,false,phone,adress);
    	try {
    		ReaderAndWriter.refresh();
			ReaderAndWriter.twrite(t1);
		} catch (IOException e) {
			e.printStackTrace();
		}}
    	
    }
    @FXML
    public void initialize() {
    	traderTypeComboBox.getItems().addAll("Buyer","Seller");
    }

}

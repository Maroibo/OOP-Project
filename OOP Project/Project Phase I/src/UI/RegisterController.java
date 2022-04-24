package UI;

import java.io.IOException;
import java.util.Optional;

import eQatarSystem.Trader;
import files.ReaderAndWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private TextField adressTextField;

    @FXML
    private Button backButton;

    @FXML
    private Button clearButton;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private Button registerButton;

    @FXML
    private Label signInLBL;

    @FXML
    private ComboBox<String> traderTypeComboBox;

    @FXML
    void onBackClick(ActionEvent event) {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Canelation Panel");
    	alert.setHeaderText("Are you sure you want to cancel this form?");
    	Optional<ButtonType> result=alert.showAndWait();
    	if(result.isPresent()&&result.get()==ButtonType.OK) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("mainPane.fxml"));
                Stage stage = (Stage) backButton.getScene().getWindow();
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
            }catch (IOException io){
                io.printStackTrace();
            }
    	}
    }

    @FXML
    void onClearClicked(ActionEvent event) {
    	idTextField.setText("");
    	nameTextField.setText("");
    	adressTextField.setText("");
    	phoneTextField.setText("");
    	traderTypeComboBox.setPromptText("Choose Type of Trader");
    	
    }

    @FXML
    void onRegisterClick(ActionEvent event) throws ClassNotFoundException {
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
                Stage stage = (Stage) registerButton.getScene().getWindow();
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
		}            
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SellerMainPane.fxml"));
            Stage stage = (Stage) registerButton.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    	}
    }

    @FXML
    void onSignInLBLClicked(MouseEvent event) {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("loginPane.fxml"));
            Stage stage = (Stage) signInLBL.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }
    
    @FXML
    public void initialize() {
    	traderTypeComboBox.getItems().addAll("Buyer", "Seller");

    }

}

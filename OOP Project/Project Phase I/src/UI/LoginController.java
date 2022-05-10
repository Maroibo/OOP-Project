package UI;

import java.io.IOException;
import java.util.function.UnaryOperator;

import eQatarSystem.Trader;
import files.ReaderAndWriter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener.Change;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Button backButton;

    @FXML
    private Button clearButton;

    @FXML
    private TextField idTextField;

    @FXML
    private Button loginButton;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private Label registerLBL;

    private boolean loginisBlankChecker() {
    	if(idTextField.getText().isBlank() || phoneNumberTextField.getText().isBlank()) {
    		return true;
    	} else
    		return false;
    }
    
    @FXML
    void onBackClicked(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainPane.fxml"));
            Stage stage = (Stage) backButton.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }}

    @FXML
    void onClearClicked(ActionEvent event) {
    	idTextField.setText("");
    	phoneNumberTextField.setText("");
    }

    @FXML
    void onLoginButton(ActionEvent event) throws ClassNotFoundException, IOException {
    	if(loginisBlankChecker()) {
    		Alert alert=new Alert(AlertType.ERROR);
        	alert.setTitle("Invalid Data");
        	alert.setHeaderText("Invalid Data Passed or Empty Input");
        	alert.setContentText("You have to insert valid data.");
        	alert.showAndWait();
    	} else {
    		//This is the Admin panel for testing purposes only.
    		if(idTextField.getText().equals("000") && phoneNumberTextField.getText().equals("000")) {
				try {
		            FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		            Stage stage = (Stage) loginButton.getScene().getWindow();
		            Scene scene = new Scene(loader.load());
		            stage.setScene(scene);
		        }catch (IOException io){
		            io.printStackTrace();
		        }
			} else {
    		ReaderAndWriter.refresh();
        	Trader t=ReaderAndWriter.sys.findTrader(Integer.parseInt(idTextField.getText()));
	    	if(t!=null) {
	    		if(t.getId()==Integer.parseInt(idTextField.getText())&&t.getPhoneNumber()==Integer.parseInt(phoneNumberTextField.getText())) {
	    			ReaderAndWriter.currentLog(t);
	    			if(t.isBuyer()) {
	    		        try {
	    		            FXMLLoader loader = new FXMLLoader(getClass().getResource("BuyerMainPane.fxml"));
	    		            Stage stage = (Stage) backButton.getScene().getWindow();
	    		            Scene scene = new Scene(loader.load());
	    		            stage.setScene(scene);
	    		        }catch (IOException io){
	    		            io.printStackTrace();
	    		        }
	    			}if(t.isSeller()) {
	    		        try {
	    		            FXMLLoader loader = new FXMLLoader(getClass().getResource("SellerMainPane.fxml"));
	    		            Stage stage = (Stage) backButton.getScene().getWindow();
	    		            Scene scene = new Scene(loader.load());
	    		            stage.setScene(scene);
	    		        }catch (IOException io){
	    		            io.printStackTrace();
	    		        }
	    			}
	    				
	    		}
	    	} else {
        	Alert alert=new Alert(AlertType.ERROR);
        	alert.setTitle("Login Error");
        	alert.setHeaderText("Trader Not Found");
        	alert.setContentText("ID or Phone Number is Incorrect");
        	alert.showAndWait();
	    	}}
    	}
    }

    @FXML
    void onRegisterLBLClicked(MouseEvent event) {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("registrationPane.fxml"));
            Stage stage = (Stage) registerLBL.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    
    }
    @FXML
    void loginValidation(KeyEvent event) {
    	idTextField.setTextFormatter(new TextFormatter<>(c -> {
    	    if (!c.getControlNewText().matches("\\d*")) 
    	        return null;
    	    else
    	        return c;
    	    }
    	));
}
    @FXML
    void loginValidation1(KeyEvent event) {
    	phoneNumberTextField.setTextFormatter(new TextFormatter<>(c -> {
    	    if (!c.getControlNewText().matches("\\d*")) 
    	        return null;
    	    else
    	        return c;
    	    }
    	));
    }
}
package UI;

import java.io.IOException;
import java.util.Optional;

import eQatarSystem.*;
import files.ReaderAndWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
    void onLoginButton(ActionEvent event) {

    }
    @FXML
    void onSubmitClicked(ActionEvent event) throws ClassNotFoundException, IOException {
    	ReaderAndWriter.refresh();
    	Trader t=ReaderAndWriter.sys.findTrader(Integer.parseInt(idTextField.getText()));
    	if(t!=null) {
    		if(t.getId()==Integer.parseInt(idTextField.getText())) {
    			if(t.isBuyer()) {
    		        try {
    		            FXMLLoader loader = new FXMLLoader(getClass().getResource("BuyerMainPane.fxml"));
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
        	alert.setTitle("Error");
        	alert.setHeaderText("Trader Not Found");
        	alert.setContentText("Id or Phone number is incorrect");
        	alert.showAndWait();
    	}
    			
    }

}

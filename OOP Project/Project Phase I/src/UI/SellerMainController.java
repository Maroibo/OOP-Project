package UI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

public class SellerMainController {

    @FXML
    private TableColumn<?, ?> brandColumn1;

    @FXML
    private Button closeDealButton;

    @FXML
    private TableColumn<?, ?> colorColumn1;

    @FXML
    private TableColumn<?, ?> idColumn1;

    @FXML
    private Button logoutButton;

    @FXML
    private TableColumn<?, ?> priceColumn1;

    @FXML
    private Button saveButton;

    @FXML
    private Button sellButton;

    @FXML
    private TableColumn<?, ?> soldColumn1;

    @FXML
    private TableColumn<?, ?> typeColomn;

    @FXML
    private Button updateButton;

    @FXML
    void onCloseDealClick(ActionEvent event) {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CloseDealSmartphonePane.fxml"));
            Stage stage = (Stage) closeDealButton.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }

    @FXML
    void onLogoutClick(ActionEvent event) {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("loginPane.fxml"));
            Stage stage = (Stage) logoutButton.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }
    
    @FXML
    void onSaveClick(ActionEvent event) {

    }

    @FXML
    void onSellClick(ActionEvent event) {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SellPane.fxml"));
            Stage stage = (Stage) sellButton.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }

    @FXML
    void onUpdateClick(ActionEvent event) {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateSmartphonePane.fxml"));
            Stage stage = (Stage) updateButton.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }

}

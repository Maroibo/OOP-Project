package UI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;

public class SellerMainController {

    @FXML
    private TreeTableView<?> ItemsTable;

    @FXML
    private TreeTableColumn<?, ?> brandColumn;

    @FXML
    private Button closeDealButton;

    @FXML
    private TreeTableColumn<?, ?> colorColumn;

    @FXML
    private TreeTableColumn<?, ?> idColumn;

    @FXML
    private TreeTableColumn<?, ?> itemsColumn;

    @FXML
    private Button logoutButton;

    @FXML
    private TreeTableColumn<?, ?> priceColumn;

    @FXML
    private Button saveButton;

    @FXML
    private Button sellButton;

    @FXML
    private TreeTableColumn<?, ?> soldColumn;

    @FXML
    private TreeTableColumn<?, ?> typeColumn;

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

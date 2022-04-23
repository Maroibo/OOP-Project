package UI;

import java.io.IOException;
import java.util.Optional;

import eQatarSystem.Electronic;
import files.ReaderAndWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class BuyerMainController {


    @FXML
    private Button buyButton;

    @FXML
    private Button dealsOnHoldButton;
    
    @FXML
    private TreeTableView<Electronic> ItemsTable;

    @FXML
    private TreeTableColumn<Electronic,String> descriptionColumn;

    @FXML
    private ComboBox<ElectronicType> filterComboBox;

    @FXML
    private TreeTableColumn<Electronic,Integer> itemsColumn;

    @FXML
    private Button logoutButton;

    @FXML
    void onBuyClick(ActionEvent event) {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Confirmation Panel");
    	alert.setHeaderText("Are you sure you want to buy this item?");
    	alert.setContentText("Item info:");
    	Optional<ButtonType> result=alert.showAndWait();
    	if(result.isPresent()&&result.get()==ButtonType.OK) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("buyBigPane.fxml"));
                Stage stage = (Stage) buyButton.getScene().getWindow();
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
            }catch (IOException io){
                io.printStackTrace();
            }
    	}
    }

    @FXML
    void onHoldClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dealsOnHoldPane.fxml"));
            Stage stage = (Stage) buyButton.getScene().getWindow();
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
    public void initialize() throws ClassNotFoundException, IOException {
    	filterComboBox.getItems().addAll(ElectronicType.values());
    }

}

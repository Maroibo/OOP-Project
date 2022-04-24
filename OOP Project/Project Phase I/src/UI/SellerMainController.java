package UI;

import java.io.IOException;

import eQatarSystem.Electronic;
import files.ReaderAndWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SellerMainController {

    @FXML
    private TableColumn<Electronic, String> brandColumn1;

    @FXML
    private Button closeDealButton;

    @FXML
    private TableColumn<Electronic, String> colorColumn1;

    @FXML
    private TableColumn<Electronic, Integer> idColumn1;

    @FXML
    private TableView<Electronic> itemsTable;

    @FXML
    private Button logoutButton;

    @FXML
    private TableColumn<Electronic, Double> priceColumn1;

    @FXML
    private Button saveButton;

    @FXML
    private Button sellButton;

    @FXML
    private TableColumn<Electronic, Boolean> soldColumn1;

    @FXML
    private TableColumn<Electronic, String> typeColomn;

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
    void onLogoutClick(ActionEvent event) throws IOException {
    	ReaderAndWriter.removeLog();
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

    }
    void initialize() throws ClassNotFoundException, IOException {
    	typeColomn.setCellValueFactory(new PropertyValueFactory("type"));
    	idColumn1.setCellValueFactory(new PropertyValueFactory("id"));
    	priceColumn1.setCellValueFactory(new PropertyValueFactory("price"));
    	brandColumn1.setCellValueFactory(new PropertyValueFactory("brand"));
    	colorColumn1.setCellValueFactory(new PropertyValueFactory("color"));
    	soldColumn1.setCellValueFactory(new PropertyValueFactory("isSold"));
        ReaderAndWriter.refresh();
        ObservableList<Electronic> list=FXCollections.observableArrayList(ReaderAndWriter.sys.getElectronics());
        itemsTable.setItems(list);
    }
    

}


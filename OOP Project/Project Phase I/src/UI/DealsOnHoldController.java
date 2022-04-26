package UI;

import java.io.IOException;

import eQatarSystem.Deal;
import eQatarSystem.Electronic;
import eQatarSystem.Trader;
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

public class DealsOnHoldController {

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<Deal, Integer> dealNoColumn;

    @FXML
    private TableView<Deal> dealsTable;

    @FXML
    private TableColumn<Deal, Electronic> electronicItemColumn;

    @FXML
    private TableColumn<Deal, Trader> sellerContactColumn;

    @FXML
    void onBackClick(ActionEvent event) {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BuyerMainPane.fxml"));
            Stage stage = (Stage) backButton.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException io){
            io.printStackTrace();
        }
    }
    @FXML
    void initialize() throws ClassNotFoundException, IOException {
    	dealNoColumn.setCellValueFactory(new PropertyValueFactory("dealNo"));
    	electronicItemColumn.setCellValueFactory(new PropertyValueFactory("electronicItem"));
    	sellerContactColumn.setCellValueFactory(new PropertyValueFactory("seller"));
        ReaderAndWriter.refresh();
        ObservableList<Deal> list=FXCollections.observableArrayList(ReaderAndWriter.getDealsOnHold(ReaderAndWriter.getLog()));
        dealsTable.setItems(list);
    }

}

package UI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

public class DealsOnHoldController {

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<?, ?> dealNoColumn;

    @FXML
    private TableColumn<?, ?> electronicItemColumn;

    @FXML
    private TableColumn<?, ?> sellerContactColumn;

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

}

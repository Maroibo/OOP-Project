package UI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class RegisterController {

    @FXML
    private TextField adressTextField;
    @FXML
    private Button cancelButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private ComboBox<?> traderTypeComboBox;
    @FXML
    private RegistrationCancelApp cancel;

    @FXML
    void onBackClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainPane.fxml"));
            Stage stage = (Stage) backButton.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }
    @FXML
    void onCanelClick(ActionEvent event) {
//       try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("registrationCanelPane.fxml"));
//            Stage stage = (Stage) cancelButton.getScene().getWindow();
//            Scene scene = new Scene(loader.load());
//           stage.setScene(scene);
//        }catch (IOException io){
//            io.printStackTrace();
//       }
    }

}

package UI;

import java.io.IOException;

import eQatarSystem.Deal;
import eQatarSystem.Electronic;
import files.ReaderAndWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BuyBigController {

    @FXML
     Label dateCreatedLabel;

    @FXML
     Label dealNoLabel;

    @FXML
     Label invoiceNoLabel;

    @FXML
     Label invoiceStatusLabel;

    @FXML
     Label itemDescriptionLabel;

    @FXML
     Button proceedButton;

    @FXML
     Label sellerDescriptionLabel;
    
    private Deal c1;
    
    public Deal getC1() {
		return c1;
	}

	public void setC1(Deal c1) {
		this.c1 = c1;
	}

	@FXML
    void onProceedClick(ActionEvent event) throws IOException, ClassNotFoundException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BuyerMainPane.fxml"));    
        Parent root = (Parent)fxmlLoader.load();          
        BuyerMainController controller = fxmlLoader.getController();
        ReaderAndWriter.refresh();
        ObservableList<Electronic> list=FXCollections.observableArrayList(ReaderAndWriter.sys.getListOfAvailableElectronics());
        controller.itemsTable.setItems(list);
    	try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BuyerMainPane.fxml"));
            Stage stage = (Stage) proceedButton.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }
    
    

}

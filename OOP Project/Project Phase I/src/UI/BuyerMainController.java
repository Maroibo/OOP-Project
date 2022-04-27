package UI;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Optional;

import eQatarSystem.Deal;
import eQatarSystem.Electronic;
import eQatarSystem.Trader;
import files.ReaderAndWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BuyerMainController {

    @FXML
    private TableColumn<Electronic, String> brandColumn;

    @FXML
    private Button buyButton;

    @FXML
    private TableColumn<Electronic, String> colorColumn;

    @FXML
    private Button dealsOnHoldButton;

    @FXML
    private ComboBox<String> filterComboBox;

    @FXML
    private TableColumn<Electronic, Integer> idColumn;

    @FXML
     TableView<Electronic> itemsTable;

    @FXML
    private Button logoutButton;

    @FXML
    private TableColumn<Electronic, Double> priceColumn;

    @FXML
    private TableColumn<Electronic, Boolean> soldColumn;

    @FXML
    private TableColumn<Electronic, String> typeColomn;
    
    private Electronic selected;
    

    private void showAllElectronics() throws ClassNotFoundException, IOException {
    	ReaderAndWriter.refresh();
    	ObservableList<Electronic> list=FXCollections.observableArrayList(ReaderAndWriter.sys.getListOfAvailableElectronics());
        itemsTable.setItems(list);
    }
    
    private void showSmartphones() throws ClassNotFoundException, IOException {
    	ReaderAndWriter.refresh();
    	ObservableList<Electronic> list=FXCollections.observableArrayList(ReaderAndWriter.sys.getListOfAvailableSmartphone());
        itemsTable.setItems(list);
    }
    
    private void showCameras() throws ClassNotFoundException, IOException {
    	ReaderAndWriter.refresh();
    	ObservableList<Electronic> list=FXCollections.observableArrayList(ReaderAndWriter.sys.getListOfAvailableCamera());
        itemsTable.setItems(list);
    }
    
    private void showVideoGames() throws ClassNotFoundException, IOException {
    	ReaderAndWriter.refresh();
    	ObservableList<Electronic> list=FXCollections.observableArrayList(ReaderAndWriter.sys.getListOfAvailableVideoGame());
        itemsTable.setItems(list);
    }
    
    @FXML
    void handleElectronicTypeFilter(ActionEvent event) throws ClassNotFoundException, IOException {
    	String selected = filterComboBox.getValue();
    	if(selected.equalsIgnoreCase("All"))
    		showAllElectronics();
    	else if(selected.equalsIgnoreCase("Smartphone"))
    		showSmartphones();
    	else if(selected.equalsIgnoreCase("Camera"))
    		showCameras();
    	else
    		showVideoGames();
    }

    @FXML
    void onBuyClick(ActionEvent event) throws ClassNotFoundException, IOException {
    	this.selected=itemsTable.getSelectionModel().getSelectedItem();
    	if(selected != null) {
    		Alert alert=new Alert(AlertType.CONFIRMATION);
        	alert.setTitle("Confirmation Panel");
        	alert.setHeaderText("Are you sure you want to buy this item?");
        	alert.setContentText("Item info: "+selected.toString());
        	Optional<ButtonType> result=alert.showAndWait();
        	if(result.isPresent()&&result.get()==ButtonType.OK) {
        		ReaderAndWriter.refresh();
        		Trader seller = ReaderAndWriter.sys.findSellerByElectronicId(selected.getId());
        		ReaderAndWriter.refresh();
        		String date = String.format("%s",java.time.LocalDate.now());
        		Deal d = new Deal(ReaderAndWriter.getLog(), seller, selected, date);
        		ReaderAndWriter.dwrite(d);
        		ReaderAndWriter.refresh();
        		ArrayList<Electronic> electronics = ReaderAndWriter.e;
        		for(int i=0; i<electronics.size(); i++) {
        			if(electronics.get(i).getId()==selected.getId()) {
        				electronics.remove(i);
        			}
        		} ReaderAndWriter.setE(electronics);
        		ReaderAndWriter.save();
        		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("buyBigPane.fxml"));    
		        Parent root = (Parent)fxmlLoader.load();          
		        BuyBigController controller = fxmlLoader.getController();
		        controller.setC1(d);
		        controller.dealNoLabel.setText(Integer.toString(controller.getC1().getDealNo()));
		        controller.invoiceNoLabel.setText(Integer.toString(controller.getC1().getInvoice().getInvoiceNo()));
		        controller.dateCreatedLabel.setText(controller.getC1().getDateCreated());
		        controller.invoiceStatusLabel.setText(Boolean.toString(controller.getC1().getInvoice().isPaid()));
		        controller.itemDescriptionLabel.setText(controller.getC1().getElectronicItem().toString());
		        controller.sellerDescriptionLabel.setText(controller.getC1().getSeller().toString());
		        Scene scene = new Scene(root);
		        Stage stage = (Stage) buyButton.getScene().getWindow();
		        stage.setScene(scene);    
		        stage.show();
        	}
    	} else {
    		Alert alert=new Alert(AlertType.ERROR);
        	alert.setTitle("Selection Error");
        	alert.setHeaderText("Electronic Item not selected");
        	alert.setContentText("You have to select an electronic items to buy");
        	alert.showAndWait();
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
    void initialize() throws ClassNotFoundException, IOException {
    	filterComboBox.getItems().addAll("All","Smartphone","Camera","Video Game");
    	filterComboBox.getSelectionModel().selectFirst();
    	typeColomn.setCellValueFactory(new PropertyValueFactory("type"));
    	idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        priceColumn.setCellValueFactory(new PropertyValueFactory("price"));
        brandColumn.setCellValueFactory(new PropertyValueFactory("brand"));
        colorColumn.setCellValueFactory(new PropertyValueFactory("color"));
        soldColumn.setCellValueFactory(new PropertyValueFactory("isSold"));
        ReaderAndWriter.refresh();
        ObservableList<Electronic> list=FXCollections.observableArrayList(ReaderAndWriter.sys.getListOfAvailableElectronics());
        itemsTable.setItems(list);
    }
    
    @FXML
	public Electronic getSelected() {
		return selected;
	}
    @FXML
	public void setSelected(Electronic selected) {
		this.selected = selected;
	}
}
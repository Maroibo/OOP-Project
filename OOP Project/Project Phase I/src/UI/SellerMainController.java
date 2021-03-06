package UI;

import java.io.IOException;
import java.util.ArrayList;

import eQatarSystem.Deal;
import eQatarSystem.Electronic;
import eQatarSystem.Trader;
import files.ReaderAndWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Camera;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SellerMainController {

    @FXML TableColumn<Electronic, String> brandColumn1;

    @FXML
    private Button closeDealButton;

    @FXML TableColumn<Electronic, String> colorColumn1;

    @FXML TableColumn<Electronic, Integer> idColumn1;

    @FXML TableView<Electronic> itemsTable;

    @FXML
    private Button logoutButton;

    @FXML TableColumn<Electronic, Double> priceColumn1;

    @FXML
    private Button saveButton;

    @FXML
    private Button sellButton;

    @FXML TableColumn<Electronic, Boolean> soldColumn1;

    @FXML TableColumn<Electronic, String> typeColomn;

    @FXML
    private Button updateButton;
    @FXML
    private UpdateCameraController uCamera;
 
    private Electronic selected;


    @FXML
    void onCloseDealClick(ActionEvent event) throws ClassNotFoundException, IOException {
    	this.selected=itemsTable.getSelectionModel().getSelectedItem();
    	if(selected!=null) {
    		boolean exist = false;
    		for(Deal d: ReaderAndWriter.dread()) {
    			if(d.getElectronicItem().getId()==selected.getId())
    				exist = true;
    		} if(exist) {
    			if(selected.getType().equals("Camera")) {
    	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CloseDealCameraPane.fxml"));    
    		        Parent root = (Parent)fxmlLoader.load();          
    		        CloseDealCameraController controller = fxmlLoader.getController();
    		        controller.setSelected(selected);
    		        controller.CameraBrandTextField.setText(controller.getSelected().getBrand());
    		        controller.CameraColourTextField.setText(controller.getSelected().getColor());
    		        controller.CameraIdTextField.setText(Integer.toString(controller.getSelected().getId()));
    		        controller.CameraIdTextField.setEditable(false);
    		        controller.CameraLensSizeTextField.setText(controller.getSelected().getLensSize());
    		        controller.CameraPixelSizeTextField.setText(controller.getSelected().getPixelSize());
    		        controller.CameraPriceTextField.setText(Double.toString(controller.getSelected().getPrice()));
    		        controller.CameraZoomTextField.setText(controller.getSelected().getZoom());
    		        Scene scene = new Scene(root);
    		        Stage stage = (Stage) updateButton.getScene().getWindow();
    		        stage.setScene(scene);    
    		        stage.show();	
    		    	}
    	    	if(selected.getType().equals("Smartphone")) {
    	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CloseDealSmartphonePane.fxml"));    
    		        Parent root = (Parent)fxmlLoader.load();          
    		        CloseDealSmartphoneController controller = fxmlLoader.getController();
    		        controller.setSelected(selected);
    		        controller.smartphoneBrandTextField.setText(controller.getSelected().getBrand());
    		        controller.smartphoneColourTextField.setText(controller.getSelected().getColor());
    		        controller.smartphoneIdTextField.setText(Integer.toString(controller.getSelected().getId()));
    		        controller.smartphoneIdTextField.setEditable(false);
    		        controller.smartphoneCamResTextField.setText(controller.getSelected().getCameraResolution());
    		        controller.smartphonePriceTextField.setText(Double.toString(controller.getSelected().getPrice()));
    		        controller.smartphoneScreenSizeTextField.setText(controller.getSelected().getScreenSize());
    		        Scene scene = new Scene(root);
    		        Stage stage = (Stage) updateButton.getScene().getWindow();
    		        stage.setScene(scene);    
    		        stage.show();
    	    }
    	    	if(selected.getType().equals("Video Game")) {
    	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CloseDealVideoGamePane.fxml"));
    	            Parent root = (Parent)fxmlLoader.load();
    	            CloseDealVideoGameController controller = fxmlLoader.getController();
    	            controller.setSelected(selected);
    	            controller.VideoGameBrandTextField.setText(controller.getSelected().getBrand());
    	            controller.VideoGameColourTextField.setText(controller.getSelected().getColor());
    	            controller.VideoGameIdTextField.setText(Integer.toString(controller.getSelected().getId()));
    	            controller.VideoGameIdTextField.setEditable(false);
    	            controller.VideoGameConnectivityTextField.setText(controller.getSelected().getConnectivity());
    	            controller.VideoGameControllerTextField.setText(controller.getSelected().getController());
    	            controller.VideoGamePriceTextField.setText(Double.toString(controller.getSelected().getPrice()));
    	            controller.VideoGameDimensionsTextField.setText(controller.getSelected().getDimensions());
    	            controller.VideoGameDisplayTextField.setText(controller.getSelected().getDisplay());
    	            controller.VideoGameMemoryTextField.setText(controller.getSelected().getMemory());
    	            Scene scene = new Scene(root);
    	            Stage stage = (Stage) updateButton.getScene().getWindow();
    	            stage.setScene(scene);
    	            stage.show();
    	        }
    		} else {
    			Alert alert=new Alert(AlertType.ERROR);
    			alert.setTitle("Selection Error");
    			alert.setHeaderText("Deal Not Found");
    			alert.setContentText("No Deal Selected to Close.");
    			alert.showAndWait();
    		}
    	
    	} else {
	Alert alert=new Alert(AlertType.ERROR);
	alert.setTitle("Selection Error");
	alert.setHeaderText("Electronic Item not selected");
	alert.setContentText("You have to select an electronic items to close a deal");
	alert.showAndWait();
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
    void onSaveClick(ActionEvent event) throws ClassNotFoundException, IOException {
    	ArrayList<Electronic> list=ReaderAndWriter.getLog().getList();
    	ArrayList<Electronic> sold = new ArrayList<Electronic>();
    	for(Electronic e: list) {
    		if(e.getIsSold()) {
    			sold.add(e);
    		}
    	} list.removeAll(sold);
    	ReaderAndWriter.save();
    	ArrayList<Trader> traders=ReaderAndWriter.tread();
    	for(Trader t: traders) {
    		if(t.getId()==ReaderAndWriter.getLog().getId())
    			t.setElectronics(list);
    	}ReaderAndWriter.setT(traders);
    	ReaderAndWriter.save();
        ObservableList<Electronic> list1=FXCollections.observableArrayList(ReaderAndWriter.getLog().getList());
        itemsTable.setItems(list1);	
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
    void onUpdateClick(ActionEvent event) throws IOException {
    	this.selected=itemsTable.getSelectionModel().getSelectedItem();
    	if(selected!=null) {
    		if(selected.getType().equals("Camera")) {
    	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateCameraPane.fxml"));    
    	        Parent root = (Parent)fxmlLoader.load();          
    	        UpdateCameraController controller = fxmlLoader.getController();
    	        controller.setSelected(selected);
    	        controller.CameraBrandTextField.setText(controller.getSelected().getBrand());
    	        controller.CameraColourTextField.setText(controller.getSelected().getColor());
    	        controller.CameraIdTextField.setText(Integer.toString(controller.getSelected().getId()));
    	        controller.CameraIdTextField.setEditable(false);
    	        controller.CameraLensSizeTextField.setText(controller.getSelected().getLensSize());
    	        controller.CameraPixelSizeTextField.setText(controller.getSelected().getPixelSize());
    	        controller.CameraPriceTextField.setText(Double.toString(controller.getSelected().getPrice()));
    	        controller.CameraZoomTextField.setText(controller.getSelected().getZoom());
    	        Scene scene = new Scene(root);
    	        Stage stage = (Stage) updateButton.getScene().getWindow();
    	        stage.setScene(scene);    
    	        stage.show();	
    	    	}
    		if(selected.getType().equals("Video Game")) {
    	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateVideoGamePane.fxml"));    
    	        Parent root = (Parent)fxmlLoader.load();          
    	        UpdateVideoGameController controller = fxmlLoader.getController();
    	        controller.setSelected(selected);
    	        controller.VideoGameBrandTextField.setText(controller.getSelected().getBrand());
    	        controller.VideoGameColourTextField.setText(controller.getSelected().getColor());
    	        controller.VideoGameIdTextField.setText(Integer.toString(controller.getSelected().getId()));
    	        controller.VideoGameIdTextField.setEditable(false);
    	        controller.VideoGameDimensionsTextField.setText(controller.getSelected().getDimensions());
    	        controller.VideoGameMemoryTextField.setText(controller.getSelected().getMemory());
    	        controller.VideoGameControllerTextField.setText(controller.getSelected().getController());
    	        controller.VideoGamePriceTextField.setText(Double.toString(controller.getSelected().getPrice()));
    	        controller.VideoGameConnectivityTextField.setText(controller.getSelected().getConnectivity());
    	        controller.VideoGameDisplayTextField.setText(controller.getSelected().getDisplay());
    	        Scene scene = new Scene(root);
    	        Stage stage = (Stage) updateButton.getScene().getWindow();
    	        stage.setScene(scene);    
    	        stage.show();
    		}
    		if(selected.getType().equals("Smartphone")) {
    	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateSmartphonePane.fxml"));    
    	        Parent root = (Parent)fxmlLoader.load();          
    	        UpdateSmartphoneController controller = fxmlLoader.getController();
    	        controller.setSelected(selected);
    	        controller.smartphoneBrandTextField.setText(controller.getSelected().getBrand());
    	        controller.smartphoneColourTextField.setText(controller.getSelected().getColor());
    	        controller.smartphoneIdTextField.setText(Integer.toString(controller.getSelected().getId()));
    	        controller.smartphoneIdTextField.setEditable(false);
    	        controller.smartphoneCamResTextField.setText(controller.getSelected().getCameraResolution());
    	        controller.smartphoneScreenSizeTextField.setText(controller.getSelected().getScreenSize());
    	        controller.smartphonePriceTextField.setText(Double.toString(controller.getSelected().getPrice()));
    	        controller.smartphoneStorageComboBox.setValue(controller.getSelected().getStorage());
    	        Scene scene = new Scene(root);
    	        Stage stage = (Stage) updateButton.getScene().getWindow();
    	        stage.setScene(scene);    
    	        stage.show();
    		}
    	}
     else {
        	Alert alert=new Alert(AlertType.ERROR);
        	alert.setTitle("Selection Error");
        	alert.setHeaderText("Electronic Item not selected");
        	alert.setContentText("You have to select an electronic items to update");
        	alert.showAndWait();
    	    }
    }  
    @FXML
    void initialize() throws ClassNotFoundException, IOException {
    	typeColomn.setCellValueFactory(new PropertyValueFactory("type"));
    	idColumn1.setCellValueFactory(new PropertyValueFactory("id"));
    	priceColumn1.setCellValueFactory(new PropertyValueFactory("price"));
    	brandColumn1.setCellValueFactory(new PropertyValueFactory("brand"));
    	colorColumn1.setCellValueFactory(new PropertyValueFactory("color"));
    	soldColumn1.setCellValueFactory(new PropertyValueFactory("isSold"));
        ReaderAndWriter.refresh();
        ObservableList<Electronic> list=FXCollections.observableArrayList(ReaderAndWriter.getLog().getList());
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

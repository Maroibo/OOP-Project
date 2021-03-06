package UI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import eQatarSystem.Camera;
import eQatarSystem.Electronic;
import eQatarSystem.Smartphone;
import eQatarSystem.Trader;
import eQatarSystem.VideoGame;
import files.ReaderAndWriter;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class SellController {

    @FXML
    private TextField CameraBrandTextField;

    @FXML
    private TextField CameraColourTextField;

    @FXML
    private TextField CameraIdTextField;

    @FXML
    private TextField CameraLensSizeTextField;

    @FXML
    private TextField CameraPixelSizeTextField;

    @FXML
    private TextField CameraPriceTextField;

    @FXML
    private TextField CameraZoomTextField;
    
    @FXML
    private TabPane ElectronicTabPane;

    @FXML
    private TextField VideoGameBrandTextField;

    @FXML
    private TextField VideoGameColourTextField;

    @FXML
    private TextField VideoGameConnectivityTextField;

    @FXML
    private TextField VideoGameControllerTextField;

    @FXML
    private TextField VideoGameDimensionsTextField;

    @FXML
    private TextField VideoGameDisplayTextField;

    @FXML
    private TextField VideoGameIdTextField;

    @FXML
    private TextField VideoGameMemoryTextField;

    @FXML
    private TextField VideoGamePriceTextField;
    
    @FXML
    private Tab cameraTab;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField smartphoneBrandTextField;

    @FXML
    private TextField smartphoneCamResTextField;

    @FXML
    private TextField smartphoneColourTextField;

    @FXML
    private TextField smartphoneIdTextField;

    @FXML
    private TextField smartphonePriceTextField;

    @FXML
    private TextField smartphoneScreenSizeTextField;

    @FXML
    private ComboBox<String> smartphoneStorageComboBox;
    
    @FXML
    private Tab smartphoneTab;

    @FXML
    private Button submitButton;
    
    @FXML
    private Tab videoGameTab;
    
    private boolean smartphoneExist() {
    	for(Electronic e: ReaderAndWriter.e) {
    		if(e.getId()==Integer.parseInt(smartphoneIdTextField.getText())) {
    			return true;
    		}
    	}
		return false;
    }
    
    private boolean videoGameExist() {
    	for(Electronic e: ReaderAndWriter.e) {
    		if(e.getId()==Integer.parseInt(VideoGameIdTextField.getText())) {
    			return true;
    		}
    	}
		return false;
    }
    
    private boolean cameraExist() {
    	for(Electronic e: ReaderAndWriter.e) {
    		if(e.getId()==Integer.parseInt(CameraIdTextField.getText())) {
    			return true;
    		}
    	}
		return false;
    }

    @FXML
    void cameraIdValidation(KeyEvent event) {
    	CameraIdTextField.setTextFormatter(new TextFormatter<>(c -> {
    	    if (!c.getControlNewText().matches("\\d*")) 
    	        return null;
    	    else
    	        return c;
    	    }
    	));
    }

    @FXML
    void cameraPriceValidation(KeyEvent event) {
    	CameraPriceTextField.setTextFormatter(new TextFormatter<>(c -> {
    	    if (!c.getControlNewText().matches("\\d*")) 
    	        return null;
    	    else
    	        return c;
    	    }
    	));
    }
    
    @FXML
    void smartphoneIdValidation(KeyEvent event) {
    	smartphoneIdTextField.setTextFormatter(new TextFormatter<>(c -> {
    	    if (!c.getControlNewText().matches("\\d*")) 
    	        return null;
    	    else
    	        return c;
    	    }
    	));
    }

    @FXML
    void smartphonePriceValidation(KeyEvent event) {
    	smartphonePriceTextField.setTextFormatter(new TextFormatter<>(c -> {
    	    if (!c.getControlNewText().matches("\\d*")) 
    	        return null;
    	    else
    	        return c;
    	    }
    	));
    }

    @FXML
    void videoGameIdValidation(KeyEvent event) {
    	VideoGameIdTextField.setTextFormatter(new TextFormatter<>(c -> {
    	    if (!c.getControlNewText().matches("\\d*")) 
    	        return null;
    	    else
    	        return c;
    	    }
    	));
    }

    @FXML
    void videoGamePriceValidation(KeyEvent event) {
    	VideoGamePriceTextField.setTextFormatter(new TextFormatter<>(c -> {
    	    if (!c.getControlNewText().matches("\\d*")) 
    	        return null;
    	    else
    	        return c;
    	    }
    	));
    }

    private Electronic getElectronic() {
    	Electronic e = null;
    	try {
    		if(CameraIdTextField.getText().isBlank() && VideoGameIdTextField.getText().isBlank()) {
    			if(!smartphoneExist()) {
    			String type = "Smartphone";
    		    int id = Integer.parseInt(smartphoneIdTextField.getText());
    		    double price = Double.parseDouble(smartphonePriceTextField.getText());
    		    String color = smartphoneColourTextField.getText();
    		    String brand = smartphoneBrandTextField.getText();
    		    String camRes = smartphoneCamResTextField.getText();
    		    String screenSize = smartphoneScreenSizeTextField.getText();
    		    String storage = smartphoneStorageComboBox.getValue();
    		    e = new Smartphone(id, price, brand, color, storage, screenSize, camRes);
    			}}
    		else if(smartphoneIdTextField.getText().isBlank() && CameraIdTextField.getText().isBlank()) {
    			if(!videoGameExist()) {
    			String type = "Video Game";
    		    int id = Integer.parseInt(VideoGameIdTextField.getText());
    		    double price = Double.parseDouble(VideoGamePriceTextField.getText());
    		    String color = VideoGameColourTextField.getText();
    		    String brand = VideoGameBrandTextField.getText();
    		    String connectivity = VideoGameConnectivityTextField.getText();
    		    String dimensions = VideoGameDimensionsTextField.getText();
    		    String display = VideoGameDisplayTextField.getText();
    		    String controller = VideoGameControllerTextField.getText();
    		    String memory = VideoGameMemoryTextField.getText();
    		    e = new VideoGame(id, price, brand, color, memory, display, connectivity, controller, dimensions);
    			}}
    		else {
    			if(!cameraExist()) {
    			String type = "Camera";
    		    int id = Integer.parseInt(CameraIdTextField.getText());
    		    double price = Double.parseDouble(CameraPriceTextField.getText());
    		    String color = CameraColourTextField.getText();
    		    String brand = CameraBrandTextField.getText();
    		    String lensSize = CameraLensSizeTextField.getText();
    		    String pixelSize = CameraPixelSizeTextField.getText();
    		    String zoom = CameraZoomTextField.getText();
    		    e = new Camera(id, price, brand, color, pixelSize, zoom, lensSize);
    			}}
    		} catch (NumberFormatException nfe) {
    			nfe.getMessage();
    		}
    	return e;
    }
    
    private boolean smartphoneisBlankChecker() {
    	if(smartphoneIdTextField.getText().isBlank() || smartphonePriceTextField.getText().isBlank() || smartphoneColourTextField.getText().isBlank() ||
    	   smartphoneBrandTextField.getText().isBlank() || smartphoneCamResTextField.getText().isBlank() || smartphoneScreenSizeTextField.getText().isBlank() ||
    	   smartphoneStorageComboBox.getValue() == null) {
    		return true;
    	} else
    		return false;
    }
    
    private boolean videoGameisBlankChecker() {
    	if(VideoGameIdTextField.getText().isBlank() || VideoGamePriceTextField.getText().isBlank() || VideoGameColourTextField.getText().isBlank() ||
    	   VideoGameBrandTextField.getText().isBlank() || VideoGameConnectivityTextField.getText().isBlank() || VideoGameDimensionsTextField.getText().isBlank() ||
    	   VideoGameDisplayTextField.getText().isBlank() || VideoGameControllerTextField.getText().isBlank() || VideoGameMemoryTextField.getText().isBlank()) {
    		return true;
    	} else
    		return false;
    }
    
    private boolean cameraisBlankChecker() {
    	if(CameraIdTextField.getText().isBlank() || CameraPriceTextField.getText().isBlank() || CameraColourTextField.getText().isBlank() ||
    	   CameraBrandTextField.getText().isBlank() || CameraLensSizeTextField.getText().isBlank() || CameraPixelSizeTextField.getText().isBlank() ||
    	   CameraZoomTextField.getText().isBlank()) {
    		return true;
    	} else
    		return false;
    }
    
    private boolean tabisBlankChecker() {
    	String selectedTab = ElectronicTabPane.getSelectionModel().getSelectedItem().getText();
    	if(selectedTab.equalsIgnoreCase("Smartphone")) {
    		if (smartphoneisBlankChecker()) {
    			return true;
    		}else {
    			return false;
    		}
    	} if(selectedTab.equalsIgnoreCase("Video Game")) {
    		if(videoGameisBlankChecker()) {
    			return true;
    		}else {
    		 return false;
    		}
    	} if(selectedTab.equalsIgnoreCase("Camera")) {
    		if(cameraisBlankChecker()) {
    			return true;
    		} else {
    		 return false;
    		}
    	}
		return false;
    }
    
    @FXML
    void onCancelClick(ActionEvent event) {
    	try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SellerMainPane.fxml"));
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }

    @FXML
    void onSubmitClick(ActionEvent event) throws ClassNotFoundException, IOException {
    	if(tabisBlankChecker()) {
    		Alert alert=new Alert(AlertType.ERROR);
        	alert.setTitle("Invalid Data");
        	alert.setHeaderText("Invalid Data Passed or Empty Input");
        	alert.setContentText("You have to insert valid data.");
        	alert.showAndWait();
    	} else {
            try {
            	Electronic e = getElectronic();
            	if(e == null) {
            		Alert alert=new Alert(AlertType.ERROR);
                	alert.setTitle("Invalid Data");
                	alert.setHeaderText("Electronic ID already exists.");
                	alert.setContentText("You have to change the electronic ID.");
                	alert.showAndWait();
            	}
            	else {
            		Alert alert=new Alert(AlertType.CONFIRMATION);
                	alert.setTitle("Confirmation Panel");
                	alert.setHeaderText("Are you sure you want to sell this item?");
                	alert.setContentText("Item info: "+getElectronic().toString());
                	Optional<ButtonType> result=alert.showAndWait();
                	if(result.isPresent()&&result.get()==ButtonType.OK) {
            		Trader seller = ReaderAndWriter.getLog();
            		ReaderAndWriter.refresh();
            		ArrayList<Trader> traders = ReaderAndWriter.sys.getTraders();
            		for(Trader t: traders) {
            			if(t.getId()==seller.getId()) {
            				t.addElectronic(e);
            			}
            		} ReaderAndWriter.setT(traders);
            		ReaderAndWriter.getLog().addElectronic(e);
            		ReaderAndWriter.save();
            		ReaderAndWriter.ewrite(e);
            	}
                FXMLLoader loader = new FXMLLoader(getClass().getResource("SellerMainPane.fxml"));
                Stage stage = (Stage) submitButton.getScene().getWindow();
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
            }}catch (IOException io){
                io.printStackTrace();
            }
    	}
    }
    
    @FXML
    public void initialize() {
        smartphoneStorageComboBox.getItems().removeAll(smartphoneStorageComboBox.getItems());
        smartphoneStorageComboBox.getItems().addAll("16GB", "32GB", "64GB", "128GB", "256GB", "512GB", "1TB");
    } 
    
    @FXML
    void onCameraSelected(Event event) {
    	if(cameraTab.isSelected()) {
    		VideoGameBrandTextField.clear();
    		VideoGameColourTextField.clear();
    		VideoGameConnectivityTextField.clear();
    		VideoGameControllerTextField.clear();
    		VideoGameDimensionsTextField.clear();
    		VideoGameDisplayTextField.clear();
    		VideoGameIdTextField.clear();
    		VideoGameMemoryTextField.clear();
    		VideoGamePriceTextField.clear();
    		smartphoneBrandTextField.clear();
    		smartphoneCamResTextField.clear();
    		smartphoneColourTextField.clear();
    		smartphoneIdTextField.clear();
    		smartphonePriceTextField.clear();
    		smartphoneScreenSizeTextField.clear();
    		}
    	}

    @FXML
    void onSmartphoneSelected(Event event) {
    	if(smartphoneTab.isSelected()) {
    	if(VideoGameBrandTextField!=null){
		VideoGameBrandTextField.setText("");
		VideoGameColourTextField.setText("");
		VideoGameConnectivityTextField.setText("");
		VideoGameControllerTextField.setText("");
		VideoGameDimensionsTextField.setText("");
		VideoGameDisplayTextField.setText("");
		VideoGameIdTextField.setText("");
		VideoGameMemoryTextField.setText("");
		VideoGamePriceTextField.setText("");
		CameraBrandTextField.setText("");
		CameraColourTextField.setText("");
		CameraIdTextField.setText("");
		CameraLensSizeTextField.setText("");
		CameraPixelSizeTextField.setText("");
		CameraPriceTextField.setText("");
		CameraZoomTextField.setText("");}}
    }

    @FXML
    void onVideoGameSelected(Event event) {
    	if(videoGameTab.isSelected()) {
		CameraBrandTextField.setText("");
		CameraColourTextField.setText("");
		CameraIdTextField.setText("");
		CameraLensSizeTextField.setText("");
		CameraPixelSizeTextField.setText("");
		CameraPriceTextField.setText("");
		CameraZoomTextField.setText("");
		smartphoneBrandTextField.setText("");
		smartphoneCamResTextField.setText("");
		smartphoneColourTextField.setText("");
		smartphoneIdTextField.setText("");
		smartphonePriceTextField.setText("");
		smartphoneScreenSizeTextField.setText("");}
    }
}

package eQatarSystem;

/**
 * @author Mhd Hadi Nouh - 201909591
 * @version 1.0.0
 */
public class Smartphone extends Electronic {
	private String storage;
	private String screenSize;
	private String cameraResolution;
	
	public Smartphone(int id, double price, String brand, String color, String storage,
			String screenSize, String cameraResolution) {
		super(id, price, brand, color);
		this.storage = storage;
		this.screenSize = screenSize;
		this.cameraResolution = cameraResolution;
	}
	
	//setter and getter for storage
	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	//setter and getter for screenSize
	public String getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}

	//setter and getter for cameraResolution
	public String getCameraResolution() {
		return cameraResolution;
	}

	public void setCameraResolution(String cameraResolution) {
		this.cameraResolution = cameraResolution;
	}
	
	@Override
	public String toString() {
		String details = String.format("Storage: %s\n Screen Size: %s\t Camera Resolution: %s",
				this.getStorage(), this.getScreenSize(), this.getCameraResolution());
		return super.toString() + details;
	}
}
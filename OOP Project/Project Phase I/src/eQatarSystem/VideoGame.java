package eQatarSystem;

/**
 * @author Mhd Hadi Nouh - 201909591
 * @version 1.0.0
 */
public class VideoGame extends Electronic {
	private String memory;
	private String display;
	private String connectivity;
	private String controller;
	private String dimensions;
	
	public VideoGame(int id, double price, String brand, String color, String memory, String display,
			String connectivity, String controller, String dimensions) {
		super(id, price, brand, color);
		this.memory = memory;
		this.display = display;
		this.connectivity = connectivity;
		this.controller = controller;
		this.dimensions = dimensions;
	}

	//setter and getter for memory
	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}
	
	//setter and getter for display
	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	//setter and getter for connectivity
	public String getConnectivity() {
		return connectivity;
	}

	public void setConnectivity(String connectivity) {
		this.connectivity = connectivity;
	}

	//setter and getter for controller
	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	//setter and getter for dimensions
	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
	
	@Override
	public String toString() {
		String details = String.format("Memory: %s\n Display: %s\t Connectivity: %s\t Controller: %s\n Dimensions: %s",
				this.getMemory(), this.getDisplay(), this.getConnectivity(), this.getController(), this.getDimensions());
		return super.toString() + details;
	}
	
}
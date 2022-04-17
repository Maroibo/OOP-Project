package eQatarSystem;

/**
 * @author Mhd Hadi Nouh - 201909591
 * @version 1.0.0
 */
public class Camera extends Electronic {
	private String pixelSize;
	private String zoom;
	private String lensSize;
	
	public Camera(int id, double price, String brand, String color, String pixelSize, String zoom,
			String lensSize) {
		super(id, price, brand, color);
		this.pixelSize = pixelSize;
		this.zoom = zoom;
		this.lensSize = lensSize;
	}

	//setter and getter for pixelSize
	public String getPixelSize() {
		return pixelSize;
	}

	public void setPixelSize(String pixelSize) {
		this.pixelSize = pixelSize;
	}

	//setter and getter for zoom
	public String getZoom() {
		return zoom;
	}

	public void setZoom(String zoom) {
		this.zoom = zoom;
	}

	//setter and getter for lensSize
	public String getLensSize() {
		return lensSize;
	}

	public void setLensSize(String lensSize) {
		this.lensSize = lensSize;
	}
	
	@Override
	public String toString() {
		String details = String.format("Pixel Size: %s\nZoom: %s\nLens Size: %s\n",
				this.getPixelSize(), this.getZoom(), this.getLensSize());
		return super.toString() + details;
	}
}

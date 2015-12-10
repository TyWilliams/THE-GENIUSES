package vendingMachineClasses;

public class Products {

// Initializing values that will be used in the methods	
	private double price;
	private SelectionMenu productType;
	private int productInv;
	private int location;
	
// Setters and getters to be called in the main method
	public void setPrice(double x) {
		price = x;
	}
	public double getPrice() {
		return price;
	}
	public void setType(SelectionMenu x) {
		productType = x;
	}
	public SelectionMenu getType() {
		return productType;
	}
	public void setProductInv(int x) {
		productInv = x;
	}
	public int getProductInv() {
		return productInv;
	}
	public void setLocation(int x) {
		location = x;
	}
	public int getlocation() {
		return location;
	}
}

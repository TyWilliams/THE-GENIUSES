package vendingMachineClasses;

public class Products {

	private double price;
	private SelectionMenu productType;
	private int productInv;
	private int location;
	
	public void setPrice(int x) {
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

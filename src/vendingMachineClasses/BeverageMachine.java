package vendingMachineClasses;


public class BeverageMachine {
private Products[] products;
	
	public BeverageMachine(int numberOfProducts) {
		products = new Products[numberOfProducts];
	}
	public void setProducts(Products p,int index){
		products[index]=p;
	}
	public Products getProducts(int index){
		return products[index];
	}
	
	
}

package products;

public class BeverageMachine {
	//Set up array of products
	private SelectionMenu[]products;
	//establish a new beverage machine with number of products
	public BeverageMachine(int numberOfProducts) {
        products = new Products[numberOfProducts];
    }
	//Setting the location of the products object
    public void setProducts(Products p,int index){
        products[index]=p;
    }
    //Getting the products object from the location
    public Products getProducts(int index){
        return products[index];
    }

}

package main;

public class Product {
	private String ProductID;
	private String SupplierID;
	private String ProductName;
	private String ProductPrice;
	private String ProductDetails;
	
	public Product(String productID, String supplierID, String productName, String productPrice,
			String productDetails) {
		super();
		ProductID = productID;
		SupplierID = supplierID;
		ProductName = productName;
		ProductPrice = productPrice;
		ProductDetails = productDetails;
	}

	public String getProductID() {
		return ProductID;
	}
	//tidak ada setter untuk ProductID karena ID bersifat immutable

	public String getSupplierID() {
		return SupplierID;
	}
	//tidak ada setter untuk SupplierID karena ID bersifat immutable

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(String productPrice) {
		ProductPrice = productPrice;
	}

	public String getProductDetails() {
		return ProductDetails;
	}

	public void setProductDetails(String productDetails) {
		ProductDetails = productDetails;
	}
	
	
	
}

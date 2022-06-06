package main;

public class Orders {
	private String OrdersID;
	private String ProductID;
	private String ProductName;
	private String CustomerID;
	private String ShippingID;
	private String ShippingProvider;
	private int TotalPrice;
 

	public Orders(String ordersID, String productID, String productName, String customerID, String shippingID,
			String shippingProvider, int totalPrice) {
		super();
		OrdersID = ordersID;
		ProductID = productID;
		ProductName = productName;
		CustomerID = customerID;
		ShippingID = shippingID;
		ShippingProvider = shippingProvider;
		TotalPrice = totalPrice;
	}

	public String getOrdersID() {
		return OrdersID;
	}
	//tidak ada setter untuk OrdersID karena ID bersifat immutable
	public String getProductID() {
		return ProductID;
	}
	//tidak ada setter untuk ProductID karena ID bersifat immutable

	public String getCustomerID() {
		return CustomerID;
	}
	//tidak ada setter untuk CustomerID karena ID bersifat immutable

	public String getShippingID() {
		return ShippingID;
	}
	//tidak ada setter untuk ShippingID karena ID bersifat immutable

	public int getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		TotalPrice = totalPrice;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getShippingProvider() {
		return ShippingProvider;
	}

	public void setShippingProvider(String shippingProvider) {
		ShippingProvider = shippingProvider;
	}
 
}

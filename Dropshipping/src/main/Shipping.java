package main;


import java.util.Date;

public class Shipping {
	private String ShippingID;
	private String CustomerID;
	private String CustomerName;
	private String SupplierID;
	private String ShippingProvider;
	private Date ShippingEstimation;
	private int ShippingCost;
	
	public Shipping(String shippingID, String customerID, String customerName, String supplierID,
			String shippingProvider, Date shippingEstimation, int shippingCost) {
		super();
		ShippingID = shippingID;
		CustomerID = customerID;
		CustomerName = customerName;
		SupplierID = supplierID;
		ShippingProvider = shippingProvider;
		ShippingEstimation = shippingEstimation;
		ShippingCost = shippingCost;
	}

	public String getShippingID() {
		return ShippingID;
	}
	//tidak ada setter untuk ShippingID karena ID bersifat immutable
	public String getCustomerID() {
		return CustomerID;
	}
	//tidak ada setter untuk CustomerID karena ID bersifat immutable
	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getSupplierID() {
		return SupplierID;
	}
	//tidak ada setter untuk SupplierID karena ID bersifat immutable
	public String getShippingProvider() {
		return ShippingProvider;
	}

	public void setShippingProvider(String shippingProvider) {
		ShippingProvider = shippingProvider;
	}

	public Date getShippingEstimation() {
		return ShippingEstimation;
	}

	public void setShippingEstimation(Date shippingEstimation) {
		ShippingEstimation = shippingEstimation;
	}

	public int getShippingCost() {
		return ShippingCost;
	}

	public void setShippingCost(int shippingCost) {
		ShippingCost = shippingCost;
	}
	
}

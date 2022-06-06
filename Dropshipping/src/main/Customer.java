package main;

public class Customer {
	private String CustomerID;
	private String CustomerName;
	private String CustomerAddress;
	private String PaymentName;
	
	public Customer(String customerID, String customerName, String customerAddress, String paymentName) {
		super();
		CustomerID = customerID;
		CustomerName = customerName;
		CustomerAddress = customerAddress;
		PaymentName = paymentName;
	}

	public String getCustomerID() {
		return CustomerID;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getCustomerAddress() {
		return CustomerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}

	public String getPaymentName() {
		return PaymentName;
	}

	public void setPaymentName(String paymentName) {
		PaymentName = paymentName;
	}

}

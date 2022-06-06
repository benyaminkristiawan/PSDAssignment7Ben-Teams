package main;

public class Payment extends Customer{
	private String PaymentName;
	private int Balance;
	
	public Payment(String customerID, String customerName, String customerAddress, String paymentName,
			String paymentName2, int balance) {
		super(customerID, customerName, customerAddress, paymentName);
		PaymentName = paymentName2;
		Balance = balance;
	}
	public String getPaymentName() {
		return PaymentName;
	}
	public void setPaymentName(String paymentName) {
		PaymentName = paymentName;
	}
	public int getBalance() {
		return Balance;
	}
	public void setBalance(int balance) {
		Balance = balance;
	}

}

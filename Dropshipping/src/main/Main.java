package main;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Database.Connect;

public class Main {
	Scanner sc = new Scanner(System.in);
	
	//singleton design pattern
	Connect con = Connect.getInstance();
	ArrayList<Customer> customerList = new ArrayList<>();
	ArrayList<Product> productList = new ArrayList<>();
	ArrayList<Shipping> shippingList = new ArrayList<>();
	ArrayList<Orders> ordersList = new ArrayList<>();
	
	public Main() {
		// TODO Auto-generated constructor stub
		boolean isRun= true;
		int input = -1;
		do {
			do {
				mainMenu();
				try {
					input = sc.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
					input =-1;
				}sc.nextLine();
			} while (input<1 || input>6);
			
			switch (input) {
			case 1:
				loadCustomerData();
				printCustomerData();
				break;
			case 2:
				loadProductData();
				printProductData();
				break;
			case 3:
				loadShippingDetails();
				printShippingDetails();
				break;
			case 4:
				loadOrderDetails();
				printOrderDetails();
				break;
			case 5:
				isRun=!isRun;
				break;
			}
			
		} while (isRun);
	}
	
	public void mainMenu() {
		System.out.println("Dropshipping Menu");
		System.out.println("1. View Customer Data");
		System.out.println("2. View Product Data");
		System.out.println("3. View Shipping Details");
		System.out.println("4. View Order Details");
		System.out.println("5. Exit");
		System.out.println("Choose : ");
	}
	
	public void loadCustomerData(){
		String CustomerID,CustomerName, CustomerAddress, PaymentName;
		
		String query="SELECT * FROM customer";
		ResultSet rs = con.executeQuery(query);
		
		try {
			while(rs.next()) {
				CustomerID = rs.getString("CustomerID");
				CustomerName = rs.getString("CustomerName");
				CustomerAddress = rs.getString("CustomerAddress");
				PaymentName = rs.getString("PaymentName");
				
				Customer curr = new Customer(CustomerID, CustomerName, CustomerAddress, PaymentName);
				customerList.add(curr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printCustomerData() {
		for(Customer c : customerList) {
			System.out.println("Customer ID : "+c.getCustomerID());
			System.out.println("Customer Name : "+c.getCustomerName());
			System.out.println("Customer Addres : "+c.getCustomerAddress());
			System.out.println("Payment Name : "+c.getPaymentName());
			System.out.println();
		}
	}
	
	public void loadProductData(){
		String ProductID,SupplierID, ProductName, ProductPrice, ProductDetails;
		
		String query="SELECT * FROM product";
		ResultSet rs = con.executeQuery(query);
		
		try {
			while(rs.next()) {
				ProductID = rs.getString("ProductID");
				SupplierID = rs.getString("SupplierID");
				ProductName = rs.getString("ProductName");
				ProductPrice = rs.getString("ProductPrice");
				ProductDetails = rs.getString("ProductDetails");
				
				Product curr = new Product(ProductID, SupplierID, ProductName, ProductPrice, ProductDetails);
				productList.add(curr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printProductData() {
		for(Product p : productList) {
			System.out.println("Product ID : "+p.getProductID());
			System.out.println("Supplier ID : "+p.getSupplierID());
			System.out.println("Product Name : "+p.getProductName());
			System.out.println("Product Price : "+p.getProductPrice());
			System.out.println("Product Details : "+p.getProductDetails());
			System.out.println();
		}
	}
	
	public void loadShippingDetails(){
		String ShippingID,CustomerID,SupplierID, ShippingProvider,CustomerName;
		Date ShippingEstimation;
		int ShippingCost;
		
		String query="SELECT * FROM shipping JOIN customer ON shipping.customerID = customer.CustomerID";
		ResultSet rs = con.executeQuery(query);
		
		try {
			while(rs.next()) {
				ShippingID = rs.getString("ShippingID");
				CustomerID = rs.getString("CustomerID");
				CustomerName = rs.getString("CustomerName");
				SupplierID = rs.getString("SupplierID");
				ShippingProvider = rs.getString("ShippingProvider");
				ShippingEstimation = rs.getDate("ShippingEstimation");
				ShippingCost = rs.getInt("ShippingCost");
				
				Shipping curr = new Shipping(ShippingID, CustomerID, CustomerName, SupplierID, ShippingProvider, ShippingEstimation, ShippingCost);
				shippingList.add(curr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printShippingDetails() {
		for(Shipping s : shippingList) {
			System.out.println("Shipping ID : "+s.getShippingID());
			System.out.println("Customer ID : "+s.getCustomerID());
			System.out.println("Customer Name : "+s.getCustomerName());
			System.out.println("Supplier ID : "+s.getSupplierID());
			System.out.println("Shipping Provider : "+s.getShippingProvider());
			System.out.println("Shipping Estimation : "+s.getShippingEstimation());
			System.out.println("Shipping Cost : "+s.getShippingCost());
			System.out.println();
		}
	}
	
	public void loadOrderDetails(){
		String OrdersID,ProductID,ProductName,CustomerID,ShippingID, ShippingProvider;
		int TotalPrice;
		
		String query="SELECT * FROM orders JOIN product ON orders.ProductID = product.ProductID JOIN shipping ON orders.ShippingID = shipping.ShippingID";
		ResultSet rs = con.executeQuery(query);
		
		try {
			while(rs.next()) {
				OrdersID = rs.getString("OrdersID");
				ProductID = rs.getString("ProductID");
				ProductName = rs.getString("ProductName");
				CustomerID = rs.getString("CustomerID");
				ShippingID = rs.getString("ShippingID");
				ShippingProvider = rs.getString("ShippingProvider");
				TotalPrice = rs.getInt("TotalPrice");
				
				Orders curr = new Orders(OrdersID, ProductID, ProductName, CustomerID, ShippingID, ShippingProvider, TotalPrice);
				ordersList.add(curr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printOrderDetails() {
		for(Orders o : ordersList) {
			System.out.println("Orders ID : "+o.getOrdersID());
			System.out.println("Product ID : "+o.getProductID());
			System.out.println("Product Name : "+o.getProductName());
			System.out.println("Customer ID : "+o.getCustomerID());
			System.out.println("Shipping ID : "+o.getShippingID());
			System.out.println("Shipping Provider : "+o.getShippingProvider());
			System.out.println("Total Price : "+o.getTotalPrice());
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new Main();
	}

}

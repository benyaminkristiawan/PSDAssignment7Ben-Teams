package main;

public class supplier {
	private String SupplierID;
	private String SupplierName;
	public supplier(String supplierID, String supplierName) {
		super();
		SupplierID = supplierID;
		SupplierName = supplierName;
	}
	public String getSupplierID() {
		return SupplierID;
	}
	//tidak ada setter untuk SupplierID karena ID bersifat immutable
	public String getSupplierName() {
		return SupplierName;
	}
	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}
	
}

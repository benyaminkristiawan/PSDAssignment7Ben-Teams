package main;

public class AdminDropshipper {
	private String AdminUsername;
	private String AdminPassword;
	
	public AdminDropshipper(String adminUsername, String adminPassword) {
		super();
		AdminUsername = adminUsername;
		AdminPassword = adminPassword;
	}
	public String getAdminUsername() {
		return AdminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		AdminUsername = adminUsername;
	}
	public String getAdminPassword() {
		return AdminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		AdminPassword = adminPassword;
	}
	
}

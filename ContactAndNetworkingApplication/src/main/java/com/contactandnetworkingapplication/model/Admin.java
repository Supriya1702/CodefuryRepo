package com.contactandnetworkingapplication.model;

public class Admin {
	private int adminId;
	private String adminName;
	private String adminEmail;
	private int adminPhone;
	private String adminUserName;
	private String adminPassword;
//	
	//Constructors
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public Admin(int adminId, String adminName, String adminEmail, int adminPhone) {
		super();
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPhone = adminPhone;
		this.adminId = adminId;
	}
	// Getters and Setters
	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public int getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(int adminPhone) {
		this.adminPhone = adminPhone;
	}
	public int getAdminId() {
		return adminId;
	}
	
	public void setAdminId(int adminId) {
		this.adminId=  adminId;
	}
//	public String getAdminUserName() {
//		return adminUserName;
//	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Admin [adminId=");
		builder.append(adminId);
		builder.append(", adminName=");
		builder.append(adminName);
		builder.append(", adminEmail=");
		builder.append(adminEmail);
		builder.append(", adminPhone=");
		builder.append(adminPhone);
		builder.append("]\n");
		return builder.toString();
	}

//	public void setAdminUserName(String adminUserName) {
//		this.adminUserName = adminUserName;
//	}

//	public String getAdminPassword() {
//		return adminPassword;
//	}

//	public void setAdminPassword(String adminPassword) {
//		this.adminPassword = adminPassword;
//	}


	
}

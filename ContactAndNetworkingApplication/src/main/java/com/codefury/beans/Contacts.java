package com.codefury.beans;

import java.awt.Image;
import java.io.Serializable;
import java.sql.Date;

public class Contacts implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int uniqueId;
    private String fullName;
    private String email;
    private String phone_no;
    private String gender;
    private Date dateOfBirth;
    private String address;
    private String city;
    private String state;
    private String country;
    private String company;
    private Image contactImage;
    private int contact_id;
	
   
    //private int contact_id;
    public int getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}
    
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		//DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		this.dateOfBirth = java.sql.Date.valueOf(dateOfBirth);
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	public Image getContactImage() {
		return contactImage;
	}
	public int getContact_id() {
		return contact_id;
	}
	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}
	public void setContactImage(Image contactImage) {
		this.contactImage = contactImage;
	}
	@Override
	public String toString() {
		return "Contacts [uniqueId=" + uniqueId + ", fullName=" + fullName + ", email=" + email + ", phone_no="
				+ phone_no + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", city="
				+ city + ", state=" + state + ", country=" + country + ", company=" + company + ", contactImage="
				+ contactImage + "]";
	}
    
												
}

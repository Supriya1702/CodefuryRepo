package com.codefury.model;

import com.codefury.beans.Contacts;
import com.codefury.dao.ContactDAOImpl;

public class Test {
	public static void main(String args[]) throws ClassNotFoundException {
		System.out.println("before Impl");
		ContactDAOImpl cdi=new ContactDAOImpl();
		System.out.println("after Impl");
		Contacts contact = new Contacts();
		contact.setFullName("assas");
		contact.setEmail("jhj@g.com");
		contact.setPhone_no("234578901");
		contact.setGender("Male");
		contact.setDateOfBirth("1999-11-11");
		contact.setAddress("ssdd");
		contact.setCity("ssdd");
		contact.setState("ssdd");
		contact.setCountry("ssdd");
		contact.setCompany("ssdd");
		contact.setUniqueId(1);
		
		cdi.addContact(contact);
	}
}

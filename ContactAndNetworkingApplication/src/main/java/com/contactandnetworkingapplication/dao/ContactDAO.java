package com.contactandnetworkingapplication.dao;

import java.util.ArrayList;
import java.util.List;

import com.contactandnetworkingapplication.model.Contacts;

//creating interface for Contact Functionalities.
public interface ContactDAO {
	int addContact(Contacts contact) throws Exception ;
	List<Contacts> getContacts(int id) throws Exception;
	void deleteContact(List<Integer> contact_ids) throws Exception;
	void updateContactDetails();
	}

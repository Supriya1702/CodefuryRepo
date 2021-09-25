package com.contactandnetworkingapplication.dao;

import java.util.ArrayList;
import java.util.List;

import com.contactandnetworkingapplication.model.Contacts;

public interface ContactDAO {
	int addContact(Contacts contact) throws Exception ;
	void updateContactDetails();
	List<Contacts> getContacts(int id) throws Exception;
	void deleteContact(List<Integer> contact_ids) throws Exception;
	}

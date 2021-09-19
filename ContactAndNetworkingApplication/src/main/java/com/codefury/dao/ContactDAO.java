package com.codefury.dao;

import java.util.List;

import com.codefury.beans.Contacts;

public interface ContactDAO {
	int addContact(Contacts contact) throws Exception ;
	void updateContactDetails();
	List<Contacts> getContacts();
	void deleteContact();
	}

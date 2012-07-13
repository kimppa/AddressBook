package org.vaadin.addressbook.addressbook.dao;

import java.io.Serializable;
import java.util.List;

import org.vaadin.addressbook.addressbook.data.Contact;

public interface ContactsDao extends Serializable {
	
	public List<Contact> findAll();

	public void save(Contact contact);

}

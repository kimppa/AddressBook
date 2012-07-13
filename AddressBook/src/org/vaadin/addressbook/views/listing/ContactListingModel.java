package org.vaadin.addressbook.views.listing;

import java.util.ArrayList;
import java.util.List;

import org.vaadin.addressbook.views.main.ContactModel;

public class ContactListingModel {

	private List<ContactModel> contacts = new ArrayList<ContactModel>();

	public List<ContactModel> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactModel> contacts) {
		this.contacts = contacts;
	}

}

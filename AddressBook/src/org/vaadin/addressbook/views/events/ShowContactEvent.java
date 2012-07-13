package org.vaadin.addressbook.views.events;

import java.io.Serializable;

import org.vaadin.addressbook.views.main.ContactModel;

public class ShowContactEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2435488753398786822L;
	private ContactModel model;

	public ContactModel getModel() {
		return model;
	}

	public void setModel(ContactModel model) {
		this.model = model;
	}

}

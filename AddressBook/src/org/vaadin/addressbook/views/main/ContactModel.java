package org.vaadin.addressbook.views.main;

import org.vaadin.addressbook.addressbook.data.Contact;
import org.vaadin.addressbook.mvp.AbstractModel;

public class ContactModel extends AbstractModel<ContactModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5699470373763963917L;

	private Contact contact;

	public String getFirstName() {
		return getContact().getFirstName();
	}

	public void setFirstName(String firstName) {
		getContact().setFirstName(firstName);
	}

	public String getLastName() {
		return getContact().getLastName();
	}

	public void setLastName(String lastName) {
		getContact().setLastName(lastName);
	}

	public String getEmail() {
		return getContact().getEmail();
	}

	public void setEmail(String email) {
		getContact().setEmail(email);
	}

	public String getPhoneNumber() {
		return getContact().getPhoneNumber();
	}

	public void setPhoneNumber(String phoneNumber) {
		getContact().setPhoneNumber(phoneNumber);
	}

	public String getStreetAddress() {
		return getContact().getStreetAddress();
	}

	public void setStreetAddress(String streetAddress) {
		getContact().setStreetAddress(streetAddress);
	}

	public String getPostalCode() {
		return getContact().getPostalCode();
	}

	public void setPostalCode(String postalCode) {
		getContact().setPostalCode(postalCode);
	}

	public String getCity() {
		return getContact().getCity();
	}

	public void setCity(String city) {
		getContact().setCity(city);
	}

	public String getId() {
		return getContact().getId();
	}

	public void setId(String id) {
		getContact().setId(id);
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}

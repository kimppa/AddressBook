package org.vaadin.addressbook.views.contacteditor;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.inject.Inject;

import org.vaadin.addressbook.addressbook.dao.ContactsDao;
import org.vaadin.addressbook.addressbook.data.Contact;
import org.vaadin.addressbook.mvp.AbstractPresenter;
import org.vaadin.addressbook.views.events.AddNewContactEvent;
import org.vaadin.addressbook.views.events.ShowContactEvent;
import org.vaadin.addressbook.views.main.ContactModel;

@SessionScoped
public class ContactEditorPresenter extends
		AbstractPresenter<ContactEditorPresenter, ContactEditorView> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1964085733390165767L;
	private ContactModel model;
	
	@Inject
	private ContactsDao dao;

	public void saveClicked() {
		getView().saveChanges();
		dao.save(model.getContact());
	}

	public void showContactEventListener(
			@Observes(notifyObserver = Reception.IF_EXISTS) ShowContactEvent event) {
		showContactInForm(event);
	}

	private void showContactInForm(ShowContactEvent event) {
		model = event.getModel();
		getView().setModel(model);
	}
	
	public void addNewContactEventListener(
			@Observes(notifyObserver = Reception.IF_EXISTS) AddNewContactEvent event) {
		createAndShowNewContact();
	}

	private void createAndShowNewContact() {
		model = new ContactModel();
		model.setContact(new Contact());
		getView().setModel(model);
		getView().enableEditing();
	}

	public void cancelClicked() {
		getView().discardChanges();
	}

}

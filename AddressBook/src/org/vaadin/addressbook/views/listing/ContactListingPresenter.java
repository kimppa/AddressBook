package org.vaadin.addressbook.views.listing;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
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
public class ContactListingPresenter extends
		AbstractPresenter<ContactListingPresenter, ContactListingView> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -683464656268337932L;
	
	private ContactListingModel model;

	@Inject
	private Event<ShowContactEvent> showContactEvent;

	@Inject
	private ContactsDao contactDao;

	@Override
	public void init() {
		model = new ContactListingModel();

		for (Contact contact : contactDao.findAll()) {
			ContactModel contactModel = new ContactModel();
			contactModel.setContact(contact);
			model.getContacts().add(contactModel);
		}
		getView().setModel(model);
	}


	public void contactChosen(ContactModel contact) {
		ShowContactEvent event = new ShowContactEvent();
		event.setModel(contact);
		showContactEvent.fire(event);
	}
	
	public void addNewContactEventListener(
			@Observes(notifyObserver = Reception.IF_EXISTS) AddNewContactEvent event) {
		getView().deselectSelections();
	}

}

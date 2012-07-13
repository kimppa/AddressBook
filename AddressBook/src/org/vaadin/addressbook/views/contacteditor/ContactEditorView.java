package org.vaadin.addressbook.views.contacteditor;

import org.vaadin.addressbook.mvp.View;
import org.vaadin.addressbook.views.main.ContactModel;

public interface ContactEditorView extends
		View<ContactEditorPresenter, ContactEditorView> {
	
	public void setModel(ContactModel model);
	
	public void saveChanges();
	
	public void discardChanges();

	public void enableEditing();

}

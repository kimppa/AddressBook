package org.vaadin.addressbook.views.listing;

import org.vaadin.addressbook.mvp.View;

public interface ContactListingView extends
		View<ContactListingPresenter, ContactListingView> {

	public void setModel(ContactListingModel model);

	public void deselectSelections();

}

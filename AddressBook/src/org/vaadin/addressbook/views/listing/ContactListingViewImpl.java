package org.vaadin.addressbook.views.listing;

import org.vaadin.addressbook.mvp.AbstractView;
import org.vaadin.addressbook.mvp.AbstractModel.ModelChangeListener;
import org.vaadin.addressbook.views.contacteditor.ContactEditorViewImpl;
import org.vaadin.addressbook.views.main.ContactModel;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalSplitPanel;

public class ContactListingViewImpl
		extends
		AbstractView<ContactListingPresenter, ContactListingView, VerticalSplitPanel>
		implements ContactListingView, ValueChangeListener, ModelChangeListener<ContactModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5251048824803023065L;

	private Table contactDetails;

	public ContactListingViewImpl() {
		super(new VerticalSplitPanel());
	}

	@Override
	protected void init() {
		createContactTable();
		getLayout().addComponent(contactDetails);
		getLayout().addComponent(new ContactEditorViewImpl());
	}

	private void createContactTable() {
		contactDetails = new Table();
		contactDetails.setSizeFull();
		contactDetails.setSelectable(true);
		contactDetails.addListener(this);
		contactDetails.setImmediate(true);
	}

	@Override
	public Class<ContactListingPresenter> getPresenterType() {
		return ContactListingPresenter.class;
	}

	public void setModel(ContactListingModel model) {
		BeanItemContainer<ContactModel> container = new BeanItemContainer<ContactModel>(
				ContactModel.class);
		for (ContactModel contactModel : model.getContacts()) {
			container.addBean(contactModel);
			contactModel.addListener(this);
		}
		contactDetails.setContainerDataSource(container);
		contactDetails.setVisibleColumns(new String[] { "firstName",
				"lastName", "email", "phoneNumber", "streetAddress",
				"postalCode", "city" });
	}

	public void valueChange(ValueChangeEvent event) {
		ContactModel contact = (ContactModel) event.getProperty().getValue();
		getPresenter().contactChosen(contact);
	}

	@Override
	public void modelChanged(ContactModel model) {
		contactDetails.refreshRowCache();
	}

	@Override
	public void deselectSelections() {
		contactDetails.select(null);
	}

}

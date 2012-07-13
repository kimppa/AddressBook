package org.vaadin.addressbook.views.contacteditor;

import org.vaadin.addressbook.mvp.AbstractView;
import org.vaadin.addressbook.mvp.components.ModelForm;
import org.vaadin.addressbook.views.main.ContactModel;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;

public class ContactEditorViewImpl extends
		AbstractView<ContactEditorPresenter, ContactEditorView, CssLayout>
		implements ContactEditorView, ClickListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1743623145750993801L;

	private ModelForm<ContactModel> contactForm;

	private Button edit;

	private Button save;

	private Button cancel;

	private HorizontalLayout buttonLayout;

	public ContactEditorViewImpl() {
		super(new CssLayout());
	}

	public Class<ContactEditorPresenter> getPresenterType() {
		return ContactEditorPresenter.class;
	}

	@Override
	protected void init() {
		getLayout().setMargin(true);

		contactForm = new ModelForm<ContactModel>();
		contactForm.setFormFieldFactory(new ContactFieldFactory());

		getLayout().addComponent(contactForm);

		buttonLayout = new HorizontalLayout();
		buttonLayout.setSpacing(true);
		getLayout().addComponent(buttonLayout);

		edit = new Button("Edit", this);
		save = new Button("Save", this);
		cancel = new Button("Cancel", this);
	}

	public void buttonClick(ClickEvent event) {
		if (edit.equals(event.getButton())) {
			enableEditing();
		} else if (save.equals(event.getButton())) {
			getPresenter().saveClicked();
			contactForm.setReadOnly(true);
			showEditButton();
		} else if (cancel.equals(event.getButton())) {
			getPresenter().cancelClicked();
			contactForm.setReadOnly(true);
			showEditButton();
		}
	}
	
	private void showSaveAndCancelButtons() {
		buttonLayout.removeAllComponents();
		buttonLayout.addComponent(save);
		buttonLayout.addComponent(cancel);
	}

	private void showEditButton() {
		buttonLayout.removeAllComponents();
		buttonLayout.addComponent(edit);
	}

	public void setModel(ContactModel model) {
		if (model == null) {
			contactForm.getLayout().removeAllComponents();
			buttonLayout.removeAllComponents();
		} else {
			contactForm.setModel(model);
			contactForm.setVisibleItemProperties(new String[] { "firstName",
					"lastName", "email", "phoneNumber", "streetAddress",
					"postalCode", "city" });
			contactForm.setReadOnly(true);
			showEditButton();
		}
	}

	@Override
	public void saveChanges() {
		contactForm.commit();
	}

	@Override
	public void discardChanges() {
		contactForm.discard();
	}

	@Override
	public void enableEditing() {
		contactForm.setReadOnly(false);
		showSaveAndCancelButtons();
	}

}

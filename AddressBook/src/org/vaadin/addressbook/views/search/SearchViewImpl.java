package org.vaadin.addressbook.views.search;

import org.vaadin.addressbook.mvp.AbstractView;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.Reindeer;

public class SearchViewImpl extends
		AbstractView<SearchPresenter, SearchView, FormLayout> implements
		SearchView, ClickListener {

	private TextField searchTerms;
	private NativeSelect fieldToSearch;
	private CheckBox saveSearch;
	private TextField searchName;
	private Button searchButton;

	public SearchViewImpl() {
		super(new FormLayout());
	}

	@Override
	protected void init() {
		Label label = new Label("Search contacts");
		label.setStyleName(Reindeer.LABEL_H1);
		getLayout().addComponent(label);

		searchTerms = new TextField("Search terms");
		getLayout().addComponent(searchTerms);

		fieldToSearch = new NativeSelect("Field to search");
		populateFieldContainer();
		fieldToSearch.setItemCaptionPropertyId("caption");
		fieldToSearch.setNullSelectionAllowed(false);
		fieldToSearch.select("lastName");

		getLayout().addComponent(fieldToSearch);

		saveSearch = new CheckBox("Save search");
		getLayout().addComponent(saveSearch);

		searchName = new TextField("Search name");
		getLayout().addComponent(searchName);

		searchButton = new Button("Search", (ClickListener) this);
		getLayout().addComponent(searchButton);
	}

	private void populateFieldContainer() {
		fieldToSearch.addContainerProperty("caption", String.class, null);
		fieldToSearch.addItem("firstName").getItemProperty("caption")
				.setValue("First name");
		fieldToSearch.addItem("lastName").getItemProperty("caption")
				.setValue("Last name");
		fieldToSearch.addItem("email").getItemProperty("caption")
				.setValue("Email");
		fieldToSearch.addItem("phone").getItemProperty("caption")
				.setValue("Phone number");
		fieldToSearch.addItem("streetAddress").getItemProperty("caption")
				.setValue("Street address");
		fieldToSearch.addItem("postalCode").getItemProperty("caption")
				.setValue("Postal code");
		fieldToSearch.addItem("city").getItemProperty("caption")
				.setValue("City");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3662056856301405828L;

	@Override
	public Class<SearchPresenter> getPresenterType() {
		return SearchPresenter.class;
	}

	@Override
	public void buttonClick(ClickEvent event) {
		getPresenter().search(String.valueOf(searchTerms.getValue()),
				String.valueOf(fieldToSearch.getValue()),
				saveSearch.booleanValue(),
				String.valueOf(searchName.getValue()));

	}
}

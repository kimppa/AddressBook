package org.vaadin.addressbook.views.main;

import org.vaadin.addressbook.mvp.AbstractView;
import org.vaadin.addressbook.views.header.HeaderViewImpl;
import org.vaadin.addressbook.views.listing.ContactListingViewImpl;
import org.vaadin.addressbook.views.savedsearches.SavedSearchesViewImpl;
import org.vaadin.addressbook.views.search.SearchViewImpl;

import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalSplitPanel;

public class MainViewImpl extends
		AbstractView<MainPresenter, MainView, CssLayout> implements MainView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 73443595938092093L;

	private HeaderViewImpl header;

	private HorizontalSplitPanel mainSplitPanel;

	private ContactListingViewImpl contactListingView;

	private SearchViewImpl searchView;

	public MainViewImpl() {
		super(new CssLayout());
	}

	public Class<MainPresenter> getPresenterType() {
		return MainPresenter.class;
	}

	@Override
	protected void init() {
		header = new HeaderViewImpl();
		getLayout().addComponent(header);

		contactListingView = new ContactListingViewImpl();

		mainSplitPanel = new HorizontalSplitPanel();
		mainSplitPanel.setSizeFull();
		mainSplitPanel.setSplitPosition(200, UNITS_PIXELS);
		mainSplitPanel.addComponent(new SavedSearchesViewImpl());

		mainSplitPanel.addComponent(contactListingView);
		getLayout().addComponent(mainSplitPanel);

	}

	@Override
	public void openSearchView() {
		// Do not initialize the search view before it is actually needed.
		if (searchView == null) {
			searchView = new SearchViewImpl();
		}

		mainSplitPanel.setSecondComponent(searchView);
	}

}

package org.vaadin.addressbook.views.search;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.vaadin.addressbook.mvp.AbstractPresenter;
import org.vaadin.addressbook.views.events.SearchPerformedEvent;
import org.vaadin.addressbook.views.events.SearchSavedEvent;

@SessionScoped
public class SearchPresenter extends
		AbstractPresenter<SearchPresenter, SearchView> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6025801371437628883L;

	@Inject
	private Event<SearchPerformedEvent> searchPerformedEvent;

	@Inject
	private Event<SearchSavedEvent> searchSavedEvent;

	public void search(String searchTerm, String fieldToSearch,
			boolean saveSearch, String searchName) {
		SearchPerformedEvent event = new SearchPerformedEvent();
		event.setSearchTerm(searchTerm);
		event.setFieldToSearch(fieldToSearch);

		searchPerformedEvent.fire(event);

		if (saveSearch) {
			SearchSavedEvent saveEvent = new SearchSavedEvent();
			saveEvent.setSearchTerm(searchTerm);
			saveEvent.setFieldToSearch(fieldToSearch);
			saveEvent.setSearchName(searchName);

			searchSavedEvent.fire(saveEvent);
		}
	}

}

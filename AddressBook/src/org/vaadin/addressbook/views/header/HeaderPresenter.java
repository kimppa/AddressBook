package org.vaadin.addressbook.views.header;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.vaadin.addressbook.mvp.AbstractPresenter;
import org.vaadin.addressbook.views.events.AddNewContactEvent;
import org.vaadin.addressbook.views.events.SearchViewOpenedEvent;

@SessionScoped
public class HeaderPresenter extends
		AbstractPresenter<HeaderPresenter, HeaderView> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6305713530632478519L;

	@Inject
	private Event<AddNewContactEvent> addContactEvent;
	
	@Inject
	private Event<SearchViewOpenedEvent> searchViewOpenedEvent;
	
	public void addContactClicked() {
		addContactEvent.fire(new AddNewContactEvent());		
	}

	public void searchClicked() {
		searchViewOpenedEvent.fire(new SearchViewOpenedEvent());
	}

	public void shareClicked() {
		// TODO Auto-generated method stub
		
	}

	public void helpClicked() {
		// TODO Auto-generated method stub
		
	}


}

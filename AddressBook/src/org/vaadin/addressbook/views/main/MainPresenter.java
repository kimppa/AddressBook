package org.vaadin.addressbook.views.main;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;

import org.vaadin.addressbook.mvp.AbstractPresenter;
import org.vaadin.addressbook.views.events.SearchViewOpenedEvent;

@SessionScoped
public class MainPresenter extends AbstractPresenter<MainPresenter, MainView> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6608333800004625882L;
	
	public void searchViewOpenedEventListener(
			@Observes(notifyObserver = Reception.IF_EXISTS) SearchViewOpenedEvent event) {
		getView().openSearchView();
	}

}

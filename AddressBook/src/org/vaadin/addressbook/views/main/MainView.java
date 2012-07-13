package org.vaadin.addressbook.views.main;

import org.vaadin.addressbook.mvp.View;

public interface MainView extends View<MainPresenter, MainView> {

	void openSearchView();
	
}

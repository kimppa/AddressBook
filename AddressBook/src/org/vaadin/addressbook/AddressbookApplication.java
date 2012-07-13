package org.vaadin.addressbook;

import org.vaadin.addressbook.views.main.MainViewImpl;

import com.vaadin.Application;
import com.vaadin.ui.*;

public class AddressbookApplication extends Application {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8427435088834762968L;

	@Override
	public void init() {
		Window mainWindow = new Window("Addressbook Application");
		
		MainViewImpl mainView = new MainViewImpl();
		mainWindow.setContent(mainView);
		
		setMainWindow(mainWindow);
	}

}

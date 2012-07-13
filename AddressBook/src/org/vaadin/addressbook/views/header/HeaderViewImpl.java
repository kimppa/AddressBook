package org.vaadin.addressbook.views.header;

import org.vaadin.addressbook.mvp.AbstractView;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;

public class HeaderViewImpl extends AbstractView<HeaderPresenter, HeaderView, CssLayout>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5685108815039296577L;
	
	private Button addContact;
	
	private Button search;
	
	private Button share;
	
	private Button help;
	
	public HeaderViewImpl() {
		super(new CssLayout());
		setHeight("80px");
	}

	public Class<HeaderPresenter> getPresenterType() {
		return HeaderPresenter.class;
	}
	
	@Override
	protected void init() {
		createAddContactButton();		
		createSearchButton();
		createShareButton();
		createHelpButton();
	}

	private void createHelpButton() {
		help = new Button("Help", new ClickListener() {
			
			private static final long serialVersionUID = -5705926529412582677L;
			
			public void buttonClick(ClickEvent event) {
				getPresenter().helpClicked();
			}
		});
		getLayout().addComponent(help);
	}

	private void createShareButton() {
		share = new Button("Share", new ClickListener() {
			
			private static final long serialVersionUID = -5705926529412582677L;
			
			public void buttonClick(ClickEvent event) {
				getPresenter().shareClicked();
			}
		});
		getLayout().addComponent(share);
	}

	private void createSearchButton() {
		search = new Button("Search", new ClickListener() {
			
			private static final long serialVersionUID = -5705926529412582677L;
			
			public void buttonClick(ClickEvent event) {
				getPresenter().searchClicked();
			}
		});
		getLayout().addComponent(search);
	}

	private void createAddContactButton() {
		addContact = new Button("Add contact", new ClickListener() {
			
			private static final long serialVersionUID = -5705926529412582677L;

			public void buttonClick(ClickEvent event) {
				getPresenter().addContactClicked();
			}
		});
		getLayout().addComponent(addContact);
	}

}

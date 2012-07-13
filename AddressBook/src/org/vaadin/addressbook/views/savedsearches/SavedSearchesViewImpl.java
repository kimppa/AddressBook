package org.vaadin.addressbook.views.savedsearches;

import org.vaadin.addressbook.mvp.AbstractView;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.Reindeer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Tree;

public class SavedSearchesViewImpl extends
		AbstractView<SavedSearchesPresenter, SavedSearchesView, CssLayout>
		implements SavedSearchesView, ClickListener, ValueChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4589094981181052103L;

	private Button viewAll;

	private Tree savedSearches;

	public SavedSearchesViewImpl() {
		super(new CssLayout());
	}

	@Override
	protected void init() {
		getLayout().setMargin(true);
		viewAll = new Button("View all", (ClickListener) this);
		viewAll.setStyleName(Reindeer.BUTTON_LINK);
		getLayout().addComponent(viewAll);

		savedSearches = new Tree();
		savedSearches.setImmediate(true);
		savedSearches.addContainerProperty("caption", String.class, null);
		savedSearches.setItemCaptionPropertyId("caption");
		
		savedSearches.addItem("all").getItemProperty("caption")
				.setValue("Searches");

		getLayout().addComponent(savedSearches);
	};

	@Override
	public Class<SavedSearchesPresenter> getPresenterType() {
		return SavedSearchesPresenter.class;
	}

	@Override
	public void valueChange(ValueChangeEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub

	}

}

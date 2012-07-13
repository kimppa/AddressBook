package org.vaadin.addressbook.mvp.components;

import org.vaadin.addressbook.mvp.AbstractModel;

import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Form;

public class ModelForm<A extends AbstractModel<?>> extends Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7763440962348183821L;
	private A model;
	
	public void setModel(A model) {
		this.model = model;
		BeanItem<A> beanItem = new BeanItem<A>(model);
		setItemDataSource(beanItem);
	}
	
	@Override
	public void commit() throws SourceException, InvalidValueException {
		super.commit();
		model.fireChangeEvent();
	}

}

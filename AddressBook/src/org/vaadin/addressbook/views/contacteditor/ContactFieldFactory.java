package org.vaadin.addressbook.views.contacteditor;

import com.vaadin.data.Item;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.TextField;

class ContactFieldFactory extends DefaultFieldFactory {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2887885595739335887L;

	@Override
	public Field createField(Item item, Object propertyId,
			Component uiContext) {
		Field field = super.createField(item, propertyId, uiContext);
		if (field instanceof TextField) {
			((TextField) field).setNullRepresentation("");
		}

		return field;
	}

}
package org.vaadin.addressbook.views.events;

import java.io.Serializable;

public class SearchPerformedEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4523962038463701737L;

	private String searchTerm;
	private String fieldToSearch;

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	public String getFieldToSearch() {
		return fieldToSearch;
	}

	public void setFieldToSearch(String fieldToSearch) {
		this.fieldToSearch = fieldToSearch;
	}

}

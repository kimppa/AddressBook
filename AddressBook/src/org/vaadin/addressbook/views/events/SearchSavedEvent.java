package org.vaadin.addressbook.views.events;

import java.io.Serializable;

public class SearchSavedEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5135931725331877294L;

	private String searchTerm;
	private String fieldToSearch;
	private String searchName;

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

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
}

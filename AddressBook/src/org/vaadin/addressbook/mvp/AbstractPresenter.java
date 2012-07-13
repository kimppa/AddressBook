package org.vaadin.addressbook.mvp;

/*  
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
/**
 * 
 * @author Kim Leppänen
 *
 */
public abstract class AbstractPresenter<P extends Presenter<P, V>, V extends View<P, V>>
		implements Presenter<P, V> {

	private static final long serialVersionUID = -6771995859044860526L;

	private V view;

	public void setView(V view) {
		this.view = view;
	}

	public V getView() {
		return view;
	}

	public void init() {
		// Do nothing. Can be overridden if necessary.

	}
}

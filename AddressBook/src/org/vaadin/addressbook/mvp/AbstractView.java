package org.vaadin.addressbook.mvp;

import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CustomComponent;
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
public abstract class AbstractView<P extends Presenter<P, V>, V extends View<P, V>, L extends ComponentContainer>
		extends CustomComponent implements View<P, V> {

	private static final long serialVersionUID = 2551728845353529224L;

	private P presenter;

	@SuppressWarnings("unchecked")
	public AbstractView(L layout) {
		layout.setSizeFull();
		setCompositionRoot(layout);
		presenter = BeanFactory.getBean(getPresenterType());
		presenter.setView((V) this);
		setSizeFull();
		init();
		
		presenter.init();
	}

	public P getPresenter() {
		return presenter;
	}

	@SuppressWarnings("unchecked")
	public L getLayout() {
		return (L) getCompositionRoot();
	}

	protected void init() {

	}

}

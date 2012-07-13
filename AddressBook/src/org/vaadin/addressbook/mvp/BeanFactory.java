package org.vaadin.addressbook.mvp;

import java.util.Iterator;
import java.util.Set;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
public class BeanFactory {

	public static <B extends Object> B getBean(Class<B> c) {
		BeanManager beanManager = getBeanManager();
		Set<Bean<?>> beans = beanManager.getBeans(c);
		Bean<?> bean = null;

		Iterator<Bean<?>> beanIterator = beans.iterator();

		if (beanIterator.hasNext()) {
			bean = beanIterator.next();
		}

		if (bean == null) {
			throw new RuntimeException("Failed to initialize bean "
					+ c.getSimpleName());
		}

		@SuppressWarnings("unchecked")
		B pojo = (B) beanManager.getReference(bean, bean.getBeanClass(),
				beanManager.createCreationalContext(bean));
		return pojo;
	}

	private static BeanManager getBeanManager() {
		try {
			InitialContext initialContext = new InitialContext();
			return (BeanManager) initialContext.lookup("java:comp/BeanManager");
		} catch (NamingException e) {
			// TODO this exception should be logged
			return null;
		}
	}

}

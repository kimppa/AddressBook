package org.vaadin.addressbook.mvp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractModel<A extends AbstractModel<?>> implements Serializable {

	private static final long serialVersionUID = -4221900339942419137L;
	
	private List<ModelChangeListener<A>> listeners = new ArrayList<AbstractModel.ModelChangeListener<A>>();
	
	@SuppressWarnings("unchecked")
	public void fireChangeEvent() {
		for(ModelChangeListener<A> listener : listeners) {
			listener.modelChanged((A) this);
		}
	}
	
	public void addListener(ModelChangeListener<A> listener) {
		listeners.add(listener);
	}
	
	public void removeListener(ModelChangeListener<A> listener) {
		listeners.remove(listener);
	}
	
	public interface ModelChangeListener<A> {
		
		public void modelChanged(A model);
		
	}
}

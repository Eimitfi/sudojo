package sudojo.client.view;

import sudojo.client.viewmodel.Observer;

public abstract class AbstractView implements Observer{
	public void draw() {
		
	}
	
	public void bind() {
		
	}
	
	//public abstract void onChange(T obj);
	//c'è già questo metodo ereditato da Observer
}
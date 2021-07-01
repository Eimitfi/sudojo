package sudojo.client.view;

import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public abstract class AbstractView implements Observer<Subject>{
	public void draw() {
		
	}
	
	public void bind() {
		
	}
	
	//public abstract void onChange(T obj);
	//c'è già questo metodo ereditato da Observer
	//saranno le classi figlie a sovrascriverlo
}
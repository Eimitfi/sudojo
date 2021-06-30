package sudojo.client.viewmodel;

import java.util.ArrayList;
import java.util.Collection;

public class Result <T> implements Subject{
	private Collection<Observer<Subject>> observers;
	private T value;
	
	public Result(T v){
		this.setValue(v);
		this.observers = new ArrayList<Observer<Subject>>();
		
		
		
	}
	
	public T getValue() {
		return this.value;
	}
	
	@Override
	public boolean detach(Observer<Subject> obj) {
		// TODO Auto-generated method stub
		return this.observers.remove(obj);
		
		
	}
	@Override
	public boolean attach(Observer<Subject> obj) {
		// TODO Auto-generated method stub
		return this.observers.add(obj);
		
	}
	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for(Observer o : this.observers)
			o.onChange(this);
		
		
	}
	
	public void setValue(T value) {
		this.value = value;
	}

}

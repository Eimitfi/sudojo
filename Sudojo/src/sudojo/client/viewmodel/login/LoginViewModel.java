package sudojo.client.viewmodel.login;

import java.util.ArrayList;
import java.util.Collection;

import sudojo.client.model.login.StatoLogin;
import sudojo.client.viewmodel.AbstractViewModel;
import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public class LoginViewModel extends AbstractViewModel implements LoginViewModelInterface{
	private Collection<Observer<Subject>> observers;
	
	public LoginViewModel() {
		this.observers = new ArrayList<Observer<Subject>>();
	}

	@Override
	public boolean detach(Observer<Subject> obj) {
		return this.observers.remove(obj);
	}

	@Override
	public boolean attach(Observer<Subject> obj) {
		return this.observers.add(obj);
	}

	@Override
	public void notifyObserver() {
		for(Observer o : this.observers)
			o.onChange(this);
		
	}
	
	@Override
	public StatoLogin login(String user, String pswd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cambiaPassword(String user, String pswd) {
		// TODO Auto-generated method stub
		return false;
	}

}

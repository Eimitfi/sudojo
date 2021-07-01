package sudojo.client.viewmodel.login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import sudojo.client.model.login.StatoLogin;
import sudojo.client.model.net.Argomento;
import sudojo.client.model.net.Comando;
import sudojo.client.model.net.Request;
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
		for(Observer<Subject> o : this.observers)
			o.onChange(this);
		
	}

	@Override
	public void login(String user, String pswd) throws IOException {
		// TODO Auto-generated method stub
		Argomento username = new Argomento("username", user);
		Argomento password = new Argomento("password", pswd);
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(username);
		args.add(password);
		this.request(new Request(Comando.LOGIN, args));
		
	}

	@Override
	public void cambiaPassword(String user, String pswd) throws IOException {
		// TODO Auto-generated method stub
		Argomento username = new Argomento("username", user);
		Argomento password = new Argomento("password", pswd);
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(username);
		args.add(password);
		this.request(new Request(Comando.CAMBIA_PSWD, args));
	}
	


}

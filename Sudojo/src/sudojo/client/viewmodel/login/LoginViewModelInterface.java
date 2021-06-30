package sudojo.client.viewmodel.login;

import sudojo.client.model.login.StatoLogin;

public interface LoginViewModelInterface {
	public StatoLogin login(String user, String pswd);
	public boolean cambiaPassword(String user, String pswd);
}

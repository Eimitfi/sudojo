package sudojo.client.viewmodel.login;

import java.io.IOException;

import sudojo.client.model.login.StatoLogin;

public interface LoginViewModelInterface {
	public void login(String user, String pswd) throws IOException;
	public void cambiaPassword(String user, String pswd) throws IOException;
}

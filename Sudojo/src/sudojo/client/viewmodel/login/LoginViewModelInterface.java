package sudojo.client.viewmodel.login;

public interface LoginViewModelInterface {
	public StatoLogin login(String user, String pswd);
	public boolean cambiaPassword(String user, String pswd);
}

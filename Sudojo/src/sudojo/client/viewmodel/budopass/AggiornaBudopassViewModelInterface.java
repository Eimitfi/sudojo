package sudojo.client.viewmodel.budopass;

public interface AggiornaBudopassViewModelInterface {
	public boolean aggiornaBudopass(String user, Seminario s);
	public boolean aggiornaBudopass(String user, Grado g);
	public boolean aggiornaBudopass(String user, Competizione c, Posizione p);
	
}

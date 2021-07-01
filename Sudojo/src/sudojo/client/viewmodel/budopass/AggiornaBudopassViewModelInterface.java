package sudojo.client.viewmodel.budopass;

import java.io.IOException;

import sudojo.client.model.budopass.Competizione;
import sudojo.client.model.budopass.Grado;
import sudojo.client.model.budopass.Posizione;
import sudojo.client.model.budopass.Seminario;

public interface AggiornaBudopassViewModelInterface {
	public void aggiornaBudopass(String user, Seminario s) throws IOException;
	public void aggiornaBudopass(String user, Grado g) throws IOException;
	public void aggiornaBudopass(String user, Competizione c, Posizione p) throws IOException;
	
}

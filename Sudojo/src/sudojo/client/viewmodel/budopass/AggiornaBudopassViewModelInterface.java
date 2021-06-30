package sudojo.client.viewmodel.budopass;

import sudojo.client.model.budopass.Competizione;
import sudojo.client.model.budopass.Grado;
import sudojo.client.model.budopass.Posizione;
import sudojo.client.model.budopass.Seminario;

public interface AggiornaBudopassViewModelInterface {
	public boolean aggiornaBudopass(String user, Seminario s);
	public boolean aggiornaBudopass(String user, Grado g);
	public boolean aggiornaBudopass(String user, Competizione c, Posizione p);
	
}

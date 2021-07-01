package sudojo.client.viewmodel.creaAvviso;

import java.io.IOException;
import java.util.Collection;

import sudojo.client.model.avviso.Avviso;

public interface CreaAvvisoViewModelInterface {
	public void creaAvviso(Avviso avviso, Collection<String> users) throws IOException;
	

}

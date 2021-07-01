package sudojo.client.viewmodel.affiliato;

import java.io.IOException;

import sudojo.client.model.gestioneAffiliato.Affiliato;

public interface CancellaAffiliatoViewModelInterface {
	public void cancellaAffiliato(Affiliato affiliato) throws IOException; //quale classe affiliato? Affiliato di model.elenchi o di model.gestioneAffiliato?
	
}

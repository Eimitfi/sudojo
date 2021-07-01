package sudojo.client.viewmodel.ricevute;

import java.io.IOException;
import java.util.List;

import sudojo.client.model.pagamento.Pagamento;

public interface RicevuteViewModelInterface {
	public void generaRicevute(List<Pagamento> pagamenti) throws IOException;
	

}

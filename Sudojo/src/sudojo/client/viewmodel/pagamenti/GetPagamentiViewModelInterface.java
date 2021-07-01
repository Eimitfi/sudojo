package sudojo.client.viewmodel.pagamenti;

import java.io.IOException;
import java.util.List;

import sudojo.client.model.pagamento.Pagamento;

public interface GetPagamentiViewModelInterface {
	public void getAllPagamenti() throws IOException;
	public void getPagamentiByIscritto(String iscritto) throws IOException;
	

}

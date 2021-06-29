package sudojo.client.viewmodel.pagamenti;

import java.util.List;

public interface GetPagamentiViewModelInterface {
	public List<Pagamento> getAllPagamenti();
	public List<Pagamento> getPagamentiByIscritto(String iscritto);
	

}

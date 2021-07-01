package sudojo.client.model.net;

public interface ResponseInterface {
	public Comando getComando();
	public String getRisultato();
	public String getException();
	public Stato getStato();

}

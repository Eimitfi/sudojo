package sudojo.broker1;

public class Response implements ResponseInterface{
	private Comando comando;
	private String risultato;
	private String exception;
	private Stato stato;
	public Comando getComando() {
		return comando;
	}
	public void setComando(Comando comando) {
		this.comando = comando;
	}
	public String getRisultato() {
		return risultato;
	}
	public void setRisultato(String risultato) {
		this.risultato = risultato;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public Stato getStato() {
		return stato;
	}
	public void setStato(Stato stato) {
		this.stato = stato;
	}
	
	public Response(Comando comando) {
		super();
		this.comando = comando;
		this.risultato = null;
		this.exception = null;
		this.stato = Stato.OK;
		
	}
	public Response(Comando comando, String risultato, String exception, Stato stato) {
		super();
		this.comando = comando;
		this.risultato = risultato;
		this.exception = exception;
		this.stato = stato;
	}
}

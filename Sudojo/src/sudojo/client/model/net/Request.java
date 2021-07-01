package sudojo.client.model.net;

import java.util.List;

public class Request {
	private Comando comando;
	private List<Argomento> argomenti;
	public Comando getComando() {
		return comando;
	}
	public void setComando(Comando comando) {
		this.comando = comando;
	}
	public List<Argomento> getArgomenti() {
		return argomenti;
	}
	public void setArgomenti(List<Argomento> argomenti) {
		this.argomenti = argomenti;
	}
	public Request(Comando comando, List<Argomento> argomenti) {
		super();
		this.comando = comando;
		this.argomenti = argomenti;
	}
	
}

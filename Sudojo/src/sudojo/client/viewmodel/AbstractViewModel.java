package sudojo.client.viewmodel;

import java.io.IOException;

import sudojo.client.model.net.HTTPSClientInterface;
import sudojo.client.model.net.Request;
import sudojo.client.model.net.RequestInterface;
import sudojo.client.model.net.Response;
import sudojo.client.model.net.ResponseInterface;

public abstract class AbstractViewModel implements Subject{
	private ResponseInterface response;
	private HTTPSClientInterface client;
	public ResponseInterface getResponse() {
		return response;
	}
	protected void setResponse(ResponseInterface response) {
		this.response = response;
		this.notifyObserver();
		
	}
	public HTTPSClientInterface getClient() {
		return client;
	}
	protected void setClient(HTTPSClientInterface client) {
		this.client = client;
	}
	protected void request(RequestInterface r) throws IOException {
		this.setResponse(this.getClient().richiedi(r));
	}
/*	allora c'erano un po' di problemi perché palesemente in fase di progetto non
 * sapevamo cosa stavamo facendo LOL
 * quindi ora ho aggiunto ResponseInterface e RequestInterface un po' dapperttuto per il
 * dependecy inversion 
 * inoltre ho fattorizzato in questa classe astratta tutte le op. comuni a tutte le classi del viewmodel
 * cercando di fare tutto tramite interfacce
 * 
 * il flow dovrebbe essere:
 * view -> si registra alla classe del viewmodel che gli server -> ne invoca il metodo (VOID)
 * -> la classe del viewmodel assembla l'oggetto RequestInterface e fa la richiesta tramite this.request(request) (metodo che sta qua sopra)
 * -> quando arriva la response da HTTPSClient viene invocato il metodo setResponse che salva la response e invoca il this.notofyObserver()
 * -> tutte le view interessate vengono notificate tramite inovcazione del loro metodo onChange(Subject subject) il quale farà subject.getResponse()
 * per ottenere un oggetto ResponseInterface e fare le cose opportune
 */
	

}

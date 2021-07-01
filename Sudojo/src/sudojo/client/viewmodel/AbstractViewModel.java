package sudojo.client.viewmodel;

import java.io.IOException;

import sudojo.client.model.net.HTTPSClientInterface;
import sudojo.client.model.net.Request;
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
	protected void request(Request r) throws IOException {
		this.setResponse(this.getClient().richiedi(r));
	}
//	rega ma sta roba a che serve? helpppp
	

}

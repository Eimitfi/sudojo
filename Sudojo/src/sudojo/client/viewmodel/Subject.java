package sudojo.client.viewmodel;

import sudojo.client.model.net.ResponseInterface;

public interface Subject {
	public boolean detach(Observer<Subject> obj);
	public boolean attach(Observer<Subject> obj);
	public void notifyObserver();
	public ResponseInterface getResponse();

}

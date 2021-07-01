package sudojo.client.viewmodel;

import sudojo.client.model.net.ResponseInterface;

public interface Subject {
	public boolean detach(Observer<Subject> obj);
	public boolean attach(Observer<Subject> obj);
	public void notifyObserver();
	public ResponseInterface getResponse();

}
//flow: la maschera (che è un observer) si binda tramite attach alla classe del viewmodel (che è un subject) che gli serve e poi 
//ne invoca i metodi. tali metodi sono void e asincroni. la rispsota arriva al viewmodel tramite
//httpsclient e quando arriva tale risposta il viewmodel aggiorna tutti i suoi osservatori
//(tramite notifyObserver che per ogni observer ne fa observer.onChange(this))
//nella onChange(Subject subject) la maschera fa subject.getResponse() per ottenere
//la risposta che arriva dal broker e maneggiarla opportunamente
package sudojo.client.viewmodel;

public interface Subject {
	public boolean detach(Observer<Subject> obj);
	public boolean attach(Observer<Subject> obj);
	public void notifyObserver();

}

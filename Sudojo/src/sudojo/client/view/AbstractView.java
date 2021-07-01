package sudojo.client.view;

import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public abstract class AbstractView implements Observer<Subject>{
	//Dubbio: draw e bind dovrebbero essere astratte perche ogni oggetto le implementa a modo suo. Messa cosi la classe sembra molto
	//un'interfaccia, dobbiamo lasciarla astratta lo stesso per dare una gerarchia ereditaria o e meglio trasformarla in interfaccia?
	//Questo anche perche non credo ci siano altri metodi da metterci dentro
	
	public abstract void draw();
	public abstract void bind();
}
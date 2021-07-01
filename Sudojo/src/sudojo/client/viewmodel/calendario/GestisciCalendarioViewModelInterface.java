package sudojo.client.viewmodel.calendario;

import java.io.IOException;

import sudojo.client.model.gestioneCalendario.Evento;

public interface GestisciCalendarioViewModelInterface {
	public void cancellaEvento(Evento evento) throws IOException;
	public void modificaEvento(Evento evento) throws IOException;
	public void creaEvento(Evento evento) throws IOException;
}

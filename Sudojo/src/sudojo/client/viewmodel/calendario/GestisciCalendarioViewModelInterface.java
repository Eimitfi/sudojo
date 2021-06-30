package sudojo.client.viewmodel.calendario;

import sudojo.client.model.gestioneCalendario.Evento;

public interface GestisciCalendarioViewModelInterface {
	public boolean cancellaEvento(Evento evento);
	public boolean modificaEvento(Evento evento);
	public boolean creaEvento(Evento evento);
}

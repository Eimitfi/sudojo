package sudojo.client.view.gestore;

import sudojo.client.view.AbstractView;
import sudojo.client.viewmodel.Subject;

public class AggiuntaGenitori extends AbstractView{
	//Dubbio su questa classe, perch� l'aggiunta/modifica dei genitori viene fatta attraverso CreaAffiliatoViewModelInterface e
	//ModificaAffiliatoViewModelInterface, quindi non so se bisognerebbe agganciarla al viewmodel oppure no. Nel caso non saprei
	//nemmeno come farlo in grafica perch� appunto dovrebbe gi� essere parte di aggiunta/modifica affiliato ed essendo una classe
	//della view non dovrei implementare logica, a regola. Ditemi voi
	
	@Override
	public void onChange(Subject obj) {
		// TODO Auto-generated method stub	
	}
}
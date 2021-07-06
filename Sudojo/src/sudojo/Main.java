package sudojo;

import java.sql.Time; 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

import sudojo.broker1.dbfakemock.FakeDB;
import sudojo.broker1.dbfakemock.model.elenchi.Affiliato;
import sudojo.broker1.dbfakemock.model.elenchi.ElencoAffiliati;
import sudojo.broker1.dbfakemock.model.gestioneAffiliato.Carica;
import sudojo.broker1.dbfakemock.model.gestioneAffiliato.Credenziali;
import sudojo.broker1.dbfakemock.model.gestioneCalendario.Evento;

public class Main {
	
	public static void main(String[] args) {
		Gson g = new Gson();
		FakeDB test = new FakeDB();
		Evento evento = new Evento("ciao", "pordenone","ciaociao", new Date(), new Time(0, 0, 0));
		test.creaEvento(evento);
		List<Evento> calendario = test.getEventi();
		for(Evento e : calendario) {
			System.out.println(e.getDescrizione()+" "+e.getLuogo()+" "+e.getTitolo()+" "+e.getData().toString()+" "+e.getOra().toString());
		}
		
		ElencoAffiliati ea = test.getAffiliati();
		for(Affiliato affiliato : ea.getAffiliati()) {
			System.out.println(affiliato.getCognome()+" "+affiliato.getNome()+" "+affiliato.getUser());
		}
		
		System.out.println(test.modificaAffiliato(new sudojo.broker1.dbfakemock.model.gestioneAffiliato.Affiliato("Paolox", "Pierobon", "Via del Beccacino 7", "3456716705", "Foggia", new Date(12, 4, 1980), "paolopierobon@email.net", "PAOPBN80D12G888M", new Credenziali("paolo", false, "paolo"), Carica.DIRETTORE, null,null)));
		ea = test.getAffiliati();
		for(Affiliato affiliato : ea.getAffiliati()) {
			System.out.println(affiliato.getCognome()+" "+affiliato.getNome()+" "+affiliato.getUser());
		}
		
		System.out.println(test.login("federico", "federico"));
		System.out.println(test.login("michele.dragos", "password"));
		System.out.println(test.login("paolo", "paolo"));
		System.out.println(test.login("federico", "fedferico"));

	}

}

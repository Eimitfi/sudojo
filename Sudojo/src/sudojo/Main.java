package sudojo;

import sudojo.broker1.dbfakemock.FakeDB;
import sudojo.broker1.dbfakemock.model.elenchi.Affiliato;
import sudojo.broker1.dbfakemock.model.elenchi.ElencoAffiliati;

public class Main {
	
	public static void main() {
		FakeDB test = new FakeDB();
		ElencoAffiliati ea = test.getAffiliati();
		for(Affiliato affiliato : ea.getAffiliati()) {
			System.out.println(affiliato.getCognome()+" "+affiliato.getNome()+" "+affiliato.getUser());
		}
	}

}

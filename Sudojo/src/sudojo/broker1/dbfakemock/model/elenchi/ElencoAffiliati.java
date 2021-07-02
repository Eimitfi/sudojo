package sudojo.client.model.elenchi;

import java.util.List;

public class ElencoAffiliati {
	private List<Affiliato> affiliati;

	public List<Affiliato> getAffiliati() {
		return affiliati;
	}

	public void setAffiliati(List<Affiliato> affiliati) {
		this.affiliati = affiliati;
	}

	public ElencoAffiliati(List<Affiliato> affiliati) {
		super();
		this.affiliati = affiliati;
	}
	
	
}

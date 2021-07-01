package sudojo.client.model.elenchi;

import java.util.List;

public class ElencoIscritti {
	private List<Iscritto> iscritti;

	public List<Iscritto> getIscritti() {
		return iscritti;
	}

	public void setIscritti(List<Iscritto> iscritti) {
		this.iscritti = iscritti;
	}

	public ElencoIscritti(List<Iscritto> iscritti) {
		super();
		this.iscritti = iscritti;
	}
	
	
}

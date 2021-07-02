package sudojo.client.model.elenchi;

import java.util.List;

public class ElencoAllievi {
	private List<Allievo> allievi;

	public List<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}

	public ElencoAllievi(List<Allievo> allievi) {
		super();
		this.allievi = allievi;
	}
	
	
}

package sudojo.broker1.dbfakemock.model.budopass;

public class Partecipa {
	private Competizione competizione;
	private Posizione posizione;
	
	public Partecipa(Competizione competizione, Posizione posizione) {
		super();
		this.competizione = competizione;
		this.posizione = posizione;
	}
	
	public Competizione getCompetizione() {
		return competizione;
	}
	public void setCompetizione(Competizione competizione) {
		this.competizione = competizione;
	}
	public Posizione getPosizione() {
		return posizione;
	}
	public void setPosizione(Posizione posizione) {
		this.posizione = posizione;
	}
	
	
}

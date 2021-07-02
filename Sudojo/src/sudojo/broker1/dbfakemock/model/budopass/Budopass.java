package sudojo.broker1.dbfakemock.model.budopass;

import java.util.List;

public class Budopass {
	private List<Partecipa> competizioniPartecipate;
	private List<StoricoGrado> gradiOttenuti;
	private List<Seminario> seminariSeguiti;
	
	public Budopass(List<Partecipa> competizioniPartecipate, List<StoricoGrado> gradiOttenuti,
			List<Seminario> seminariSeguiti) {
		super();
		this.competizioniPartecipate = competizioniPartecipate;
		this.gradiOttenuti = gradiOttenuti;
		this.seminariSeguiti = seminariSeguiti;
	}
	public List<Partecipa> getCompetizioniPartecipate() {
		return competizioniPartecipate;
	}
	public void setCompetizioniPartecipate(List<Partecipa> competizioniPartecipate) {
		this.competizioniPartecipate = competizioniPartecipate;
	}
	public List<StoricoGrado> getGradiOttenuti() {
		return gradiOttenuti;
	}
	public void setGradiOttenuti(List<StoricoGrado> gradiOttenuti) {
		this.gradiOttenuti = gradiOttenuti;
	}
	public List<Seminario> getSeminariSeguiti() {
		return seminariSeguiti;
	}
	public void setSeminariSeguiti(List<Seminario> seminariSeguiti) {
		this.seminariSeguiti = seminariSeguiti;
	}
	
	
}

package sudojo.broker1.dbfakemock.model.budopass;

import java.util.Date;
import java.util.List;

public class Budopass {
	private List<Partecipa> competizioniPartecipate;
	private List<StoricoGrado> gradiOttenuti;
	private List<Seminario> seminariSeguiti;
	private String iscritto;
	
	public Budopass(List<Partecipa> competizioniPartecipate, List<StoricoGrado> gradiOttenuti,
			List<Seminario> seminariSeguiti, String iscritto) {
		super();
		this.competizioniPartecipate = competizioniPartecipate;
		this.gradiOttenuti = gradiOttenuti;
		this.seminariSeguiti = seminariSeguiti;
		this.iscritto = iscritto;
	}
	
	public boolean addPartecipa(Competizione c, Posizione p) {
		return this.competizioniPartecipate.add(new Partecipa(c, p));
	}
	
	public boolean addSeminario(Seminario s) {
		return this.seminariSeguiti.add(s);
	}
	
	public boolean addGrado(Grado g) {
		return this.gradiOttenuti.add(new StoricoGrado(g, new Date()));
	}
	
	public String getIscritto() {
		return this.iscritto;
	}
	
	public void setIscritto(String iscritto) {
		this.iscritto = iscritto;
		
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

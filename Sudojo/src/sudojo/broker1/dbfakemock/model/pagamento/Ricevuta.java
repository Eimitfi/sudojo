package sudojo.broker1.dbfakemock.model.pagamento;

import java.time.Period;
import java.util.Date;

public class Ricevuta {
	private String nomePalestra;
	private String sedeLegale;
	private String PA;
	private float importo;
	private String cognomePagante;
	private Period periodoRiferimento;
	private String cognomeIscritto;
	private Date dataNascitaIscritto;
	private String luogoNascitaIscritto;
	private Date dataEmissioneRicevuta;
	private String residenzaIscritto;
	private String causale;
	private String nomeIscritto;
	private String nomePagante;
	public String getNomePalestra() {
		return nomePalestra;
	}
	public void setNomePalestra(String nomePalestra) {
		this.nomePalestra = nomePalestra;
	}
	public String getSedeLegale() {
		return sedeLegale;
	}
	public void setSedeLegale(String sedeLegale) {
		this.sedeLegale = sedeLegale;
	}
	public String getPA() {
		return PA;
	}
	public void setPA(String pA) {
		PA = pA;
	}
	public float getImporto() {
		return importo;
	}
	public void setImporto(float importo) {
		this.importo = importo;
	}
	public String getCognomePagante() {
		return cognomePagante;
	}
	public void setCognomePagante(String cognomePagante) {
		this.cognomePagante = cognomePagante;
	}
	public Period getPeriodoRiferimento() {
		return periodoRiferimento;
	}
	public void setPeriodoRiferimento(Period periodoRiferimento) {
		this.periodoRiferimento = periodoRiferimento;
	}
	public String getCognomeIscritto() {
		return cognomeIscritto;
	}
	public void setCognomeIscritto(String cognomeIscritto) {
		this.cognomeIscritto = cognomeIscritto;
	}
	public Date getDataNascitaIscritto() {
		return dataNascitaIscritto;
	}
	public void setDataNascitaIscritto(Date dataNascitaIscritto) {
		this.dataNascitaIscritto = dataNascitaIscritto;
	}
	public String getLuogoNascitaIscritto() {
		return luogoNascitaIscritto;
	}
	public void setLuogoNascitaIscritto(String luogoNascitaIscritto) {
		this.luogoNascitaIscritto = luogoNascitaIscritto;
	}
	public Date getDataEmissioneRicevuta() {
		return dataEmissioneRicevuta;
	}
	public void setDataEmissioneRicevuta(Date dataEmissioneRicevuta) {
		this.dataEmissioneRicevuta = dataEmissioneRicevuta;
	}
	public String getResidenzaIscritto() {
		return residenzaIscritto;
	}
	public void setResidenzaIscritto(String residenzaIscritto) {
		this.residenzaIscritto = residenzaIscritto;
	}
	public String getCausale() {
		return causale;
	}
	public void setCausale(String causale) {
		this.causale = causale;
	}
	public String getNomeIscritto() {
		return nomeIscritto;
	}
	public void setNomeIscritto(String nomeIscritto) {
		this.nomeIscritto = nomeIscritto;
	}
	public String getNomePagante() {
		return nomePagante;
	}
	public void setNomePagante(String nomePagante) {
		this.nomePagante = nomePagante;
	}
	public Ricevuta(String nomePalestra, String sedeLegale, String pA, float importo, String cognomePagante,
			Period periodoRiferimento, String cognomeIscritto, Date dataNascitaIscritto, String luogoNascitaIscritto,
			Date dataEmissioneRicevuta, String residenzaIscritto, String causale, String nomeIscritto,
			String nomePagante) {
		super();
		this.nomePalestra = nomePalestra;
		this.sedeLegale = sedeLegale;
		PA = pA;
		this.importo = importo;
		this.cognomePagante = cognomePagante;
		this.periodoRiferimento = periodoRiferimento;
		this.cognomeIscritto = cognomeIscritto;
		this.dataNascitaIscritto = dataNascitaIscritto;
		this.luogoNascitaIscritto = luogoNascitaIscritto;
		this.dataEmissioneRicevuta = dataEmissioneRicevuta;
		this.residenzaIscritto = residenzaIscritto;
		this.causale = causale;
		this.nomeIscritto = nomeIscritto;
		this.nomePagante = nomePagante;
	}
	
	
	
}

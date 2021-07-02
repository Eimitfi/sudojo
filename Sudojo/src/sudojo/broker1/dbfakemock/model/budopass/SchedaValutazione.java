package sudojo.broker1.dbfakemock.model.budopass;

public class SchedaValutazione {
	private int valutazioneKihon;
	private String commentiKihon;
	private String shihoKihon;
	private int valutazioneKata;
	private String commentiKata;
	private int valutazioneKumite;
	private String commentiKumite;
	private String tipoKumite;
	private String commentiTeoriaEtica;
	private int totale;
	private String legendaPunteggio;
	private String username;
	private Grado gradoOttenuto;
	public SchedaValutazione(int valutazioneKihon, String commentiKihon, String shihoKihon, int valutazioneKata,
			String commentiKata, int valutazioneKumite, String commentiKumite, String tipoKumite,
			String commentiTeoriaEtica, int totale, String legendaPunteggio, String username, Grado gradoOttenuto) {
		super();
		this.valutazioneKihon = valutazioneKihon;
		this.commentiKihon = commentiKihon;
		this.shihoKihon = shihoKihon;
		this.valutazioneKata = valutazioneKata;
		this.commentiKata = commentiKata;
		this.valutazioneKumite = valutazioneKumite;
		this.commentiKumite = commentiKumite;
		this.tipoKumite = tipoKumite;
		this.commentiTeoriaEtica = commentiTeoriaEtica;
		this.totale = totale;
		this.legendaPunteggio = legendaPunteggio;
		this.username = username;
		this.gradoOttenuto = gradoOttenuto;
	}
	public int getValutazioneKihon() {
		return valutazioneKihon;
	}
	public void setValutazioneKihon(int valutazioneKihon) {
		this.valutazioneKihon = valutazioneKihon;
	}
	public String getCommentiKihon() {
		return commentiKihon;
	}
	public void setCommentiKihon(String commentiKihon) {
		this.commentiKihon = commentiKihon;
	}
	public String getShihoKihon() {
		return shihoKihon;
	}
	public void setShihoKihon(String shihoKihon) {
		this.shihoKihon = shihoKihon;
	}
	public int getValutazioneKata() {
		return valutazioneKata;
	}
	public void setValutazioneKata(int valutazioneKata) {
		this.valutazioneKata = valutazioneKata;
	}
	public String getCommentiKata() {
		return commentiKata;
	}
	public void setCommentiKata(String commentiKata) {
		this.commentiKata = commentiKata;
	}
	public int getValutazioneKumite() {
		return valutazioneKumite;
	}
	public void setValutazioneKumite(int valutazioneKumite) {
		this.valutazioneKumite = valutazioneKumite;
	}
	public String getCommentiKumite() {
		return commentiKumite;
	}
	public void setCommentiKumite(String commentiKumite) {
		this.commentiKumite = commentiKumite;
	}
	public String getTipoKumite() {
		return tipoKumite;
	}
	public void setTipoKumite(String tipoKumite) {
		this.tipoKumite = tipoKumite;
	}
	public String getCommentiTeoriaEtica() {
		return commentiTeoriaEtica;
	}
	public void setCommentiTeoriaEtica(String commentiTeoriaEtica) {
		this.commentiTeoriaEtica = commentiTeoriaEtica;
	}
	public int getTotale() {
		return totale;
	}
	public void setTotale(int totale) {
		this.totale = totale;
	}
	public String getLegendaPunteggio() {
		return legendaPunteggio;
	}
	public void setLegendaPunteggio(String legendaPunteggio) {
		this.legendaPunteggio = legendaPunteggio;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Grado getGradoOttenuto() {
		return gradoOttenuto;
	}
	public void setGradoOttenuto(Grado gradoOttenuto) {
		this.gradoOttenuto = gradoOttenuto;
	}
	


}

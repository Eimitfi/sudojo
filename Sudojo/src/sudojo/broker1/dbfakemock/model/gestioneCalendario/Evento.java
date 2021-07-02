package sudojo.broker1.dbfakemock.model.gestioneCalendario;

import java.sql.Time;
import java.util.Date;

public class Evento {
	private String titolo;
	private String luogo;
	private String descrizione;
	private Date data;
	private Time ora;
	
	public Evento(String titolo, String luogo, Date data, Time ora) {
		super();
		this.titolo = titolo;
		this.luogo = luogo;
		this.descrizione = "";
		this.data = data;
		this.ora = ora;
	}
	
	public Evento(String titolo, String luogo, String descrizione, Date data, Time ora) {
		super();
		this.titolo = titolo;
		this.luogo = luogo;
		this.descrizione = descrizione;
		this.data = data;
		this.ora = ora;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getLuogo() {
		return luogo;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Time getOra() {
		return ora;
	}
	public void setOra(Time ora) {
		this.ora = ora;
	}
	
	
}

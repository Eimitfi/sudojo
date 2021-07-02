package sudojo.client.model.gestioneAffiliato;

import java.util.Date;

public abstract class Persona {
	private String nome;
	private String cognome;
	private String residenza;
	private String numTelefono;
	private String luogoNascita;
	private Date dataNascita;
	private String email;
	private String CF;
	
	
	public Persona(String nome, String cognome, String residenza, String luogoNascita, Date dataNascita, String cF) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.residenza = residenza;
		this.luogoNascita = luogoNascita;
		this.dataNascita = dataNascita;
		CF = cF;
	}
	public Persona(String nome, String cognome, String residenza, String luogoNascita, Date dataNascita, String email,
			String cF) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.residenza = residenza;
		this.luogoNascita = luogoNascita;
		this.dataNascita = dataNascita;
		this.email = email;
		CF = cF;
	}
	public Persona(String nome, String cognome, String residenza, String numTelefono, String luogoNascita,
			Date dataNascita, String cF) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.residenza = residenza;
		this.numTelefono = numTelefono;
		this.luogoNascita = luogoNascita;
		this.dataNascita = dataNascita;
		CF = cF;
	}
	public Persona(String nome, String cognome, String residenza, String numTelefono, String luogoNascita,
			Date dataNascita, String email, String cF) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.residenza = residenza;
		this.numTelefono = numTelefono;
		this.luogoNascita = luogoNascita;
		this.dataNascita = dataNascita;
		this.email = email;
		CF = cF;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getResidenza() {
		return residenza;
	}
	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}
	public String getNumTelefono() {
		return numTelefono;
	}
	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}
	public String getLuogoNascita() {
		return luogoNascita;
	}
	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		CF = cF;
	}
	
	
}

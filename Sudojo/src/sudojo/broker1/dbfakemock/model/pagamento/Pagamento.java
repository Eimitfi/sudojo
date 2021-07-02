package sudojo.client.model.pagamento;

import java.time.Period;
import java.util.Date;

public class Pagamento {
	private Date data;
	private Period periodo;
	private float importo;
	private String CFPagante;
	private String cognomePagante;
	private String userIscritto;
	private String nomeIscritto;
	private String nomePagante;
	
	
	
	public Pagamento(Date data, Period periodo, float importo, String cFPagante, String cognomePagante,
			String userIscritto, String nomeIscritto, String nomePagante) {
		super();
		this.data = data;
		this.periodo = periodo;
		this.importo = importo;
		CFPagante = cFPagante;
		this.cognomePagante = cognomePagante;
		this.userIscritto = userIscritto;
		this.nomeIscritto = nomeIscritto;
		this.nomePagante = nomePagante;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Period getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Period periodo) {
		this.periodo = periodo;
	}
	public float getImporto() {
		return importo;
	}
	public void setImporto(float importo) {
		this.importo = importo;
	}
	public String getCFPagante() {
		return CFPagante;
	}
	public void setCFPagante(String cFPagante) {
		CFPagante = cFPagante;
	}
	public String getCognomePagante() {
		return cognomePagante;
	}
	public void setCognomePagante(String cognomePagante) {
		this.cognomePagante = cognomePagante;
	}
	public String getUserIscritto() {
		return userIscritto;
	}
	public void setUserIscritto(String userIscritto) {
		this.userIscritto = userIscritto;
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
	
	
}

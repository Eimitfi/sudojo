package sudojo.broker1.dbfakemock.model.budopass;

import java.util.Date;

public class Competizione {
	private String nome;
	private Date data;
	private String categoria;
	private boolean diGruppo;
	private String disciplina;
	
	public Competizione(String nome, Date data, String categoria, boolean diGruppo, String disciplina) {
		super();
		this.nome = nome;
		this.data = data;
		this.categoria = categoria;
		this.diGruppo = diGruppo;
		this.disciplina = disciplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public boolean isDiGruppo() {
		return diGruppo;
	}

	public void setDiGruppo(boolean diGruppo) {
		this.diGruppo = diGruppo;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	
}

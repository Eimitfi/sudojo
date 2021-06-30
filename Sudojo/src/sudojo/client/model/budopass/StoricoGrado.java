package sudojo.client.model.budopass;

import java.util.Date;

public class StoricoGrado {
	private Grado grado;
	private Date dataOttenimento;
	public StoricoGrado(Grado grado, Date dataOttenimento) {
		super();
		this.grado = grado;
		this.dataOttenimento = dataOttenimento;
	}
	public Grado getGrado() {
		return grado;
	}
	public void setGrado(Grado grado) {
		this.grado = grado;
	}
	public Date getDataOttenimento() {
		return dataOttenimento;
	}
	public void setDataOttenimento(Date dataOttenimento) {
		this.dataOttenimento = dataOttenimento;
	}
	
	
}

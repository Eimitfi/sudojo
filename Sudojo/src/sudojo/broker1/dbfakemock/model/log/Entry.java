package sudojo.client.model.log;

import java.sql.Time;
import java.util.Date;

public class Entry {
	private Time ora;
	private Date data;
	private String messaggio;
	
	public Entry(Time ora,Date data,String messaggio) {
		this.ora = ora;
		this.data = data;
		this.messaggio = messaggio;
	}
	
	public Time getOra() {
		return this.ora;
	}
	
	public String getMsg() {
		return this.messaggio;
	}
	
	public Date getDate() {
		return this.data;
	}
}

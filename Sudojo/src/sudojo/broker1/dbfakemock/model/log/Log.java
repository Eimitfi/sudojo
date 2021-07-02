package sudojo.broker1.dbfakemock.model.log;

import java.util.List;

public class Log {
	private List<Entry> entries;
	
	public Log(List<Entry> entries) {
		this.entries = entries;
	}
}

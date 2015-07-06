package hr.fer.zemris.ooup.labos_2.zadatak3;


public class Query {
	
	private String table;
	private String column;
	private String key;
	
	public Query(String table, String column, String key) {
		super();
		this.table = table;
		this.column = column;
		this.key = key;
	}

	public String getTable() {
		return table;
	}

	public String getColumn() {
		return column;
	}

	public String getKey() {
		return key;
	}
		
}

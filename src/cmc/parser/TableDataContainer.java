package cmc.parser;

import java.util.List;

public class TableDataContainer {
	
	private List<String> headers;
	private List<List<String>> rows;
	
	public TableDataContainer(List<String> headers, List<List<String>> rows) {
		this.setHeaders(headers);
		this.setRows(rows);
	}

	public List<String> getHeaders() {
		return headers;
	}

	public void setHeaders(List<String> headers) {
		this.headers = headers;
	}

	public List<List<String>> getRows() {
		return rows;
	}

	public void setRows(List<List<String>> rows) {
		this.rows = rows;
	}

}

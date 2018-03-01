package cmc.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TableParser {
	
	public static Element getTable(String url) {
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Grab page
		//Element table = doc.getElementById("my-table"); // Get table with id "my-table"
		if (doc != null) {
			Elements tables = doc.getElementsByTag("table");
			if (tables.size() > 1 && tables.size() != 0) {
				return tables.get(0);
			}
		}
		
		return null;
	}
	
	public static TableDataContainer getTableData(String url) {
		//https://stackoverflow.com/questions/10771218/how-to-get-a-table-from-an-html-page-using-java
		Element table = TableParser.getTable(url);
		Elements tableHeaderElements = table.select("thead tr th");
		List<String> headerElements = parseHeaders(tableHeaderElements);
		
		Elements tableRowElements = table.select(":not(thead) tr");
		List<List<String>> rows = parseRows(tableRowElements);
		
		return new TableDataContainer(headerElements, rows);
	}
	
	private static List<String> parseHeaders(Elements headerElements) {
		List<String> headerElems = new ArrayList<String>();
		for (Element header : headerElements) {
			headerElems.add(header.text());
		}
		return headerElems;
	}
	
	private static List<List<String>> parseRows(Elements tableRowElements) {
		List<List<String>> rows = new ArrayList<List<String>>();
		/*
		 * Row 0 -> elem 0, elem 1, elem 2, ... , elem n
		 * Row 1 ->  elem 0, elem 1, elem 2, ... , elem n
		 *     ........
		 * Row n -> elem 0, elem 1, elem 2, ... , elem n
		 */
		List<String> rowItems = null;
		/*
		 * elem 0, elem 1, elem 2, ... , elem n
		 */
		
		for (Element row : tableRowElements) {
			rowItems = new ArrayList<String>();//Initialize Empty List
			Elements rowItemElements = row.select("td");//Select Row elements
			for (Element item : rowItemElements) {
				rowItems.add(item.text());
			}
			rows.add(rowItems);//Add list of elements to list of rows
		}
		
		return rows;
	}
}

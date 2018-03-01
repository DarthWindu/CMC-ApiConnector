package cmc.parser;

public class Tester {
	
	public static void main(String[] args) {
		String url = "https://coinmarketcap.com/currencies/ethereum/historical-data/?start=20130428&end=20180301";
		TableParser.getTable(url);
	}

}

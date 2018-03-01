package cmc.apihelper.historical;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DateBuilder {
	
	public static String convertDate(LocalDate date) {
		String strDate = date.format(DateTimeFormatter.BASIC_ISO_DATE);
		return strDate;
	}
	
	public static LocalDate parseDate(String strDate) {
		LocalDate date = LocalDate.parse(strDate, DateTimeFormatter.BASIC_ISO_DATE);
		return date;
	}
	
	public static String apiUrlBuilder(LocalDate start, LocalDate end, String currencyId) {
		String startDate = DateBuilder.convertDate(start),
				endDate = DateBuilder.convertDate(end);
		String url = "https://coinmarketcap.com/currencies/" + currencyId + 
				"/historical-data/?start=" + startDate + "&end=" +endDate;
		return url;
	}
	
	public static String apiUrlBuilder(LocalDate start, String currencyId) {
		LocalDate end = LocalDate.now();
		return DateBuilder.apiUrlBuilder(start, end, currencyId);
	}

}

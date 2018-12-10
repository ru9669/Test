package preguntas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

public class T5P14 {
	public static void main (String args[]) {
		ZoneId zone = ZoneId.of("US/Eastern");
		List<LocalDate> dates = new ArrayList<LocalDate>();
		dates.add(LocalDate.of(2016, 3, 13));
		//dates.add(LocalDate.of(2016, 3, 40));
		dates.add(LocalDate.of(2016, 11, 6));
		dates.add(LocalDate.of(2016, 11, 7));
		//dates.add(LocalDate.of(2017, 2, 29));
		
		LocalTime time = LocalTime.of(2, 15);
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
		dates.stream().map(date -> dtf.format(ZonedDateTime.of(date, time, zone))).forEach(System.out::println);
	}
}

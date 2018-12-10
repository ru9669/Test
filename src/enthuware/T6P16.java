package enthuware;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class T6P16 {
	public static void main(String[] args) {
		LocalTime now = LocalTime.of(9, 30);
		LocalTime lt = LocalTime.of(10, 15);
		
		long timeConsumed = 0;
		long timeToStart = 0;
		
		if(now.isAfter(lt)){
			timeConsumed = lt.until(now, ChronoUnit.HOURS);
		} else{
			//timeToStart = now.until(gameStart, ChronoUnit.HOURS);
			timeToStart = now.until(lt, ChronoUnit.MINUTES);
		}
	
		System.out.println(timeToStart + " " + timeConsumed);
	}
}
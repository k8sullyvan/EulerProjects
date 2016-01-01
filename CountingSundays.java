import java.time.DayOfWeek;
import java.time.LocalDate;

public class CountingSundays {
	
	public static void main(String[] args) {
		new CountingSundays();
	}

	public CountingSundays() {
		// Original solution, without checking answers
		int sundayCount = 0;
		for (int year = 1901; year <= 2001; year++) {
			for (int month = 1; month <= 12; month++) {
				sundayCount += dateToNum(01, month, year)%7 == 0 ? 1 : 0;
			}
		}
		System.out.println(sundayCount);
		
		// Checking answer with LocalDate class
		sundayCount = 0;
		for (int year = 1901; year <= 2001; year++) {
			for (int month = 1; month <= 12; month++) {
				sundayCount += LocalDate.of(year, month, 01).getDayOfWeek().equals(DayOfWeek.SUNDAY) ? 1 : 0;
			}
		}
		System.out.println(sundayCount);
	}
	
	private int dateToNum(int day, int month, int year) {
		int num = 0;

		// There are no years in the given range that break the rules of leap years except 1900
		int leapDays = (year-1901) / 4;
		leapDays += ((year > 1900 && month > 2 && year%4 == 0) ? 1 : 0);
		
		num += daysOfCompleteMonths(month);
		num += (year - 1900) * 365;
		num += leapDays;
		num += day;
		return num;
	}

	private int daysOfCompleteMonths(int month) {
		int days = 0;
        switch (--month) {
    		case 11: days += 30;
    		case 10: days += 31;
    		case 9:  days += 30;
    		case 8:  days += 31;
    		case 7:  days += 31;
    		case 6:  days += 30;
    		case 5:  days += 31;
    		case 4:  days += 30;
    		case 3:  days += 31;
    		case 2:  days += 28;
    		case 1:  days += 31;
        	default: break;
        }
        return days;
	}
}

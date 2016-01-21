import java.time.DayOfWeek;
import java.time.LocalDate;

public class p019_CountingSundays {

	public static void main(String[] args) {
		new p019_CountingSundays();
	}

	public p019_CountingSundays() {
		int sundayCount = 0;

		sundayCount = 0;
		for (int year = 1901; year <= 2001; year++) {
			for (int month = 1; month <= 12; month++) {
				sundayCount += LocalDate.of(year, month, 01).getDayOfWeek().equals(DayOfWeek.SUNDAY) ? 1 : 0;
			}
		}
		System.out.println(sundayCount);
	}
}

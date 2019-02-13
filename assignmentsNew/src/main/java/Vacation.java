import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.WEEKS;

public class Vacation {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dMMMMyyyy");


    /**
     * To calculate number of weeks in the vacation duration starting from monday
     * <p>
     * Parsing dates to the LocalDate using the format DATE_TIME_FORMATTER => "dMMMMyyy" (Ex: 2February2019)
     * <p>
     * vacation start date is the first monday of start month.
     * start date taking the date of first day of start month
     * <p>
     * Calculating number of days to add to startDate for moving date to first monday of month.
     * day of week values starts from monday to sunday => 1 to 7
     * <p>
     * ( 8 - start.getDayOfWeek().getValue() ) % 7
     * <p>
     * which gives how many days it is before the next monday.
     * If it is already monday than ( 8 - start.getDayOfWeek().getValue() ) = > 7 and  7 % 7 => 0
     * <p>
     * To calculate till the last day of end month , taking end date as first day of its next month
     * <p>
     * WEEKS  => unit that represents a week which is equal to 7 days.
     * <p>
     * WEEKS.between(startDate, endDate) calculates number of weeks between two dates calculating from startDate each 7 days as 1 week
     *
     * @param year
     * @param startMonth
     * @param endMonth
     * @return number of weeks (@code long)
     */
    static long getNumberOfWeeksInVacation(int year, String startMonth, String endMonth) {

        LocalDate startDate = LocalDate.parse(1 + startMonth + year, DATE_TIME_FORMATTER);

        int daysToAddForFirstMonday = (8 - startDate.getDayOfWeek().getValue()) % 7;
        startDate = startDate.plusDays(daysToAddForFirstMonday);

        LocalDate endDate = LocalDate.parse(1 + endMonth + year, DATE_TIME_FORMATTER).plusMonths(1);

        return WEEKS.between(startDate, endDate);
    }


    public static void main(String[] args) {

        System.out.println(getNumberOfWeeksInVacation(2019, "February", "February"));
    }


}

package assignment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Logger;

public class KYCForm {

    private static final int DAYS_RANGE_LIMIT = 30;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final Logger LOG = Logger.getLogger(KYCForm.class.getName());


    /**
     * Calculates ranges of dates for the form date of anniversary form
     * <p>
     * range starts from -30 days of nearest anniversary
     * <p>
     * range ends at +30 days of nearest anniversary
     * if end date is after the present date than end date would be present date as range should be in past dates.
     *
     * @param signUpDate
     * @param currentDate
     * @return "startDate endDate" (@code String)
     */
    public static String getRangeOfDatesForFormDate(LocalDate signUpDate, LocalDate currentDate) {

        if (hasNoRange(signUpDate, currentDate)) {
            return "No range";
        }

        LocalDate anniversary = getAnniversaryDate(signUpDate, currentDate);

        LocalDate startDate = anniversary.minusDays(30);
        LocalDate endDate = anniversary.plusDays(30);
        if (endDate.isAfter(currentDate)) {
            endDate = currentDate;
        }

        return (startDate.format(DATE_TIME_FORMATTER) + " " + endDate.format(DATE_TIME_FORMATTER));
    }


    /**
     * Checks if present date is past the 30 days range of first anniversary
     * Sign up date is not an anniversary
     *
     * @param signUpDate
     * @param currentDate
     * @return true If present date is before the 30 day range of first anniversary
     * false otherwise
     */
    private static boolean hasNoRange(LocalDate signUpDate, LocalDate currentDate) {

        return currentDate.isBefore(signUpDate.plusYears(1).minusDays(DAYS_RANGE_LIMIT));
    }


    /**
     * Get anniversary date for KYC form filling
     * The KYC form can be filled only for the closest anniversary in the past or within 30 days range in future
     * <p>
     * Get anniversary in current year
     * <p>
     * If the present date falls in the 30 days range of next year return next year anniversary
     * else if the present date is past the 30 days range of current year anniversary return previous year anniversary
     * otherwise return current year anniversary
     *
     * @param signUpDate
     * @param currentDate
     * @return anniversary date (@code LocalDate)
     */
    private static LocalDate getAnniversaryDate(LocalDate signUpDate, LocalDate currentDate) {
        LocalDate anniversary = LocalDate.of(currentDate.getYear(), signUpDate.getMonth(), signUpDate.getDayOfMonth());

        if (anniversary.plusYears(1).minusDays(DAYS_RANGE_LIMIT).isBefore(currentDate)) {
            return anniversary.plusYears(1);

        } else if (anniversary.minusDays(DAYS_RANGE_LIMIT).isAfter(currentDate)) {
            return anniversary.minusYears(1);

        } else {
            return anniversary;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfInputs = scanner.nextInt();

        // Loop through the inputs to scan
        for (int i = 0; i < numberOfInputs; i++) {
            String signUpDateString = scanner.next();
            String currentDateString = scanner.next();
            try {
                LocalDate signUpDate = LocalDate.parse(signUpDateString, DATE_TIME_FORMATTER);
                LocalDate currentDate = LocalDate.parse(currentDateString, DATE_TIME_FORMATTER);
                LOG.info(getRangeOfDatesForFormDate(signUpDate, currentDate));
            } catch (Exception e) {
                LOG.info(e.getMessage());
            }
        }
    }
}
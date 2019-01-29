import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Logger;

public class KnowYourCustomerForm {

    private static Logger logger = Logger.getLogger(KnowYourCustomerForm.class.getName());

    /*
     *  returns nearest anniversary ( @code LocalDate )
     *  If the present date is past the +-30 days of anniversary
     *  than anniversary for filling form would be closest anniversary in the past.
     *
     *  @param signUpDate  ( registered date )
     *  @param presentDate  ( today's date )
     *
     *
     */
    private static LocalDate getNearestAnniversary(LocalDate signUpDate,LocalDate presentDate){
        LocalDate anniversary = LocalDate.of(presentDate.getYear(),signUpDate.getMonth(),signUpDate.getDayOfMonth());

        if(anniversary.minusDays(30).isAfter(anniversary)){
            anniversary = LocalDate.of(presentDate.getYear()-1,signUpDate.getMonth(),signUpDate.getDayOfMonth());
        }

        return anniversary;
    }

    /*
     *  Prints range "startDate  endDate"
     *  If present date is past to the signUpDate there is no range
     *
     *  signUpDate is not an anniversary
     *  Therefore if nearest anniversary is signUpDate then there is no range
     *
     *  range starts from -30 days of nearest anniversary
     *
     *  range ends at +30 days of nearest anniversary
     *  if end date is after the present date than end date would be present date as range should be in past dates.
     *
     *  @param signUpDate
     *  @param presentDate
     */

    public static void printRangeOfDatesForFormDate(LocalDate signUpDate, LocalDate presentDate){

        if(presentDate.isBefore(signUpDate)){
            logger.info("No Range");
            return;
        }

        LocalDate nearestAnniversary = getNearestAnniversary(signUpDate,presentDate);

        if(nearestAnniversary.equals(signUpDate)){
            logger.info("No Range");
            return;
        }

        LocalDate startDate = nearestAnniversary.minusDays(30);
        LocalDate endDate = nearestAnniversary.plusDays(30);
        if (endDate.isAfter(presentDate)){
            endDate = presentDate;
        }

        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println(startDate.format(formatter)+" "+endDate.format(formatter));
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfInputs=sc.nextInt();

        // Loop through the inputs to scan
        for(int i=0 ; i<numberOfInputs ;i++) {
            String signUpDateString = sc.next();
            String presentDateString = sc.next();
            DateTimeFormatter dateMonthYearFormat=DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try {
                LocalDate signUpDate = LocalDate.parse(signUpDateString, dateMonthYearFormat);
                LocalDate presentDate = LocalDate.parse(presentDateString, dateMonthYearFormat);
                printRangeOfDatesForFormDate(signUpDate, presentDate);
            }
            catch (Exception e){
                logger.info(e.getMessage());
            }
        }
    }
}
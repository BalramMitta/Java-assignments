import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Java4 {


    static void getRange(String signedUpDateString,String currentDateString){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate signedUpDate = LocalDate.parse(signedUpDateString,dateTimeFormatter);
        LocalDate currentDate = LocalDate.parse(currentDateString,dateTimeFormatter);

        // check if current date is greater than sign up date else no range
        if(currentDate.isAfter(signedUpDate)){

            LocalDate anniversary = LocalDate.ofYearDay(currentDate.getYear(),signedUpDate.getDayOfYear());

            //if -30 days of anniversary is greater than current date than nearest anniversary would be in previous year
            if(anniversary.minusDays(30).isAfter(anniversary)){
                anniversary = LocalDate.ofYearDay(currentDate.getYear()-1,signedUpDate.getDayOfYear());
            }

            // checking for year of anniversary is greater than sign up year
            if(anniversary.getYear()>signedUpDate.getYear()) {

                // if +30 days of anniversary is greater than current date than range ends at current date else at +30 days
                if (anniversary.plusDays(30).isAfter(currentDate)) {
                    System.out.println(anniversary.minusDays(30).format(dateTimeFormatter)
                            + " " + currentDate.format(dateTimeFormatter));
                } else {
                    System.out.println(anniversary.minusDays(30).format(dateTimeFormatter)
                            + " " + anniversary.plusDays(30).format(dateTimeFormatter));
                }
            }
            else{
                System.out.println("No range");
            }
        }
        else {
            System.out.println("No range");
        }
    }


    
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int count;

        String eachLine;

        count = scanner.nextInt();   // count of  no.of records
        scanner.nextLine();          // to break a line after integer

        while (count!=0){

            eachLine=scanner.nextLine();     // each line of record with sign up date and current date

            String[] dates=eachLine.split(" ");    // splitting line at space for dates

            getRange(dates[0],dates[1]);

            count--;

        }


    }

}

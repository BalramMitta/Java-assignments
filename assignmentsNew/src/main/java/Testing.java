import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Testing {


    static LocalDateTime parseStringToLocalDate(String string){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, y G h:mm a");

        return LocalDateTime.parse(string,formatter);
    }




    public static void main(String[] args){

        System.out.println(parseStringToLocalDate("February 2, 2019 AD 4:07 PM"));

    }
}

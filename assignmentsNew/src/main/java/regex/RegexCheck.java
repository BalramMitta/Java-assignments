package regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexCheck {

    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter a sentence");

        String sentence = scanner.nextLine();

        String matchingString = "^[A-Z].*[\\.]$";   // Regular expression for a string starting with capital letter and ending with a dot(.).

        /*
        Pattern.matches takes first argument regex and second argument string

        returns boolean value

        true if regex matches with string else false
        */

        if(Pattern.matches(matchingString,sentence))
            System.out.println("String matched");
        else
            System.out.println("Not matched with regular expression");

    }

}

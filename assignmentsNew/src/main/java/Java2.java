import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Java2 {

    public static void main(String[] args){

        String s;

        System.out.println("Enter your string");

        Scanner scanner=new Scanner(System.in);

        s= scanner.next();

        final Set<Integer> chars = new HashSet<>();   //Hashset is used because it cannot have duplicate values

        if(
                s.length() >25                              // if length of string less than 26 return false as it cannot have 26 letters(a-z)
                &&
                s.toLowerCase()                             // Converting to lower case for case insensitive
                .chars()                                    // Getting IntStream of chars in string
                .filter(i -> i >= 'a' && i <= 'z')          // Getting Stream of only alphabet
                .filter(chars::add)                         // add letters to chars set
                .anyMatch(i -> chars.size()==26)            // if chars size reaches 26 before stream ends  return true
           )
            System.out.println("True");
        else
            System.out.println("False");

    }


}

// Time complexity would be O(n)
// Space complexity would be O(n)
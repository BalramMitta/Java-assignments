package Jia2;


import java.util.ArrayList;
import java.util.Arrays;

public class Vampire {

    static int noOfDigits(long num) {
        return Long.toString(num).length();
    }

    /**
     *  Checking if it is vampire
     *
     *  Converting numbers to string to byte array
     *  one array of original number
     *  and another is joined string of num1 and num2
     *
     * Sorting arrays to check does they contain same characters( digits )
     * @param num1 factor 1
     * @param num2 factor 2
     * @param originalNumber
     * @return  true if vampire ( sorted byte arrays are equal )
     *          false otherwise
     */
    static boolean isVampire(long num1, long num2, long originalNumber) {

        // no. of digits of factored numbers must be equal and both the numbers should not have trailing zeroes
        if (noOfDigits(num1) != noOfDigits(num2) || (num1 % 10 == 0 && num2 % 10 == 0))
            return false;

        byte[] originalBytes = Long.toString(originalNumber).getBytes();
        byte[] joinedStringBytes = Long.toString(num1).concat(Long.toString(num2)).getBytes();

        Arrays.sort(originalBytes);
        Arrays.sort(joinedStringBytes);

        return Arrays.equals(originalBytes, joinedStringBytes);

    }


    /**
     *
     *  Printing first 100 vampire numbers
     *
     *  %for loop% looping from number 1000 as there is no vampire below 1000 , loop ends when count reaches 100
     *  No of digits must be odd
     *  if number of digits are odd then multiplies to get next even number of digits number
     *
     *  getting factors for each number , vampire factors have half digits each
     *
     *  %for loop% looping from first number with half number of digits to square root of number
     *
     *  if found factor check if it is vampire
     *  If it is vampire  print and increment count
     *
     * @param args
     */
    public static void main(String[] args) {

        int count = 0;

        // No Vampire number below 1000 (i.e., in the range of 10-99)
        for (long i = 1000; count < 100; i++) {

            if (noOfDigits(i) % 2 != 0) {
                i = i * 10 - 1;
                continue;
            }

            long startRange = (long) Math.pow(10, (noOfDigits(i) / 2) - 1);

            for (long num1 = startRange; num1 <= Math.sqrt(i) + 1; num1++)
                if (i % num1 == 0) {
                    long num2 = i / num1;
                    if (isVampire(num1, num2, i)) {
                        System.out.println(i + " - ( " + num1 + ", " + i / num1 + " )");
                        count++;
                        break;
                    }
                }

        }


    }

}

package Jia2;


import java.util.ArrayList;
import java.util.Arrays;

public class Vampire {

    static int noOfDigits(long num){
        return Long.toString(num).length();
    }

    static boolean isVampire(long num1,long num2,long originalNumber){

        // no. of digits of factored numbers must be equal
        if(noOfDigits(num1)!=noOfDigits(num2))
            return false;

        // both the numbers should not contain trailing zeroes
        if(num1%10==0 && num2%10==0)
            return false;

        // converting long number to string format
        String originalNumberString = Long.toString(originalNumber);
        String joinedString = Long.toString(num1).concat(Long.toString(num2));

        // converting string to byte array
        byte[] originalBytes = originalNumberString.getBytes();
        byte[] joinedStringBytes = joinedString.getBytes();

        // sorting arrays
        Arrays.sort(originalBytes);
        Arrays.sort(joinedStringBytes);

        // checking if the arrays are equal
        if(Arrays.equals(originalBytes,joinedStringBytes))
            return true;
        else
            return false;

    }




    public static void main(String[] args){

        int count = 0;

         // No Vampire number below 1000 (i.e., in the range of 10-99)
        for (long i=1000;count<100;i++){

            if(noOfDigits(i)%2!=0){                                             // if no. of digits is odd
                i=i*10-1;                                                       // multiply with 10 for making no. of digits even .
                                                                                // Subtracting 1 as it adds 1 for next loop
                continue;
            }

            long startRange = (long) Math.pow(10,(noOfDigits(i)/2)-1);          // first number with no.of digits half

            for(long num1 = startRange;num1<=Math.sqrt(i)+1;num1++){
                if(i%num1==0){                                                  // check if it is factor
                    if(isVampire(num1,i/num1,i)){                         // checking for the vampire number with the other factor i/num1
                        System.out.println(i+" - ( "+num1+", "+i/num1+" )");    //  printing vampire number with it's factors
                        count++;                                                //  incrementing the count
                        break;
                    }
                }
            }

        }


    }

}

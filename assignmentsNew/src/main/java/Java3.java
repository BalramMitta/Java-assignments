import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Java3 {


    static void runSystemPingCommand(String ip) {


        try {
            Process process = Runtime.getRuntime().exec("ping " + ip);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String s = "";
            float median;
            ArrayList<Float> pingTimes = new ArrayList<>();
            // reading output stream of the command
            while ((s = inputStream.readLine()) != null) {

                if (s.contains("time=")) {
                    //getting time from the ping command line output and converting to float value.
                    pingTimes.add(Float.valueOf(s.substring(s.lastIndexOf("=") + 1, s.lastIndexOf(" ms"))));

                    // Calculating median
                    // Getting the sorted order of times
                    Collections.sort(pingTimes);

                    // Finding the middle element for median.
                    //Check no.of total elements are odd or even as it has one middle element or two.
                    // If no.of elements is even there will be two middle elements and the median is average of two.
                    if (pingTimes.size() % 2 == 0) {
                        median = (pingTimes.get(pingTimes.size() / 2) + pingTimes.get(pingTimes.size() / 2 - 1)) / 2;
                    } else {
                        median = pingTimes.get((pingTimes.size() - 1) / 2);
                    }

                    System.out.println(median);


                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any host : ");
        String ip = scanner.next();
        runSystemPingCommand(ip);
    }

}

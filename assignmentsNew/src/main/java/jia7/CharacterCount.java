package jia7;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CharacterCount {

    public static void main(String[] args){

        try {

            String path = args[0];                                                      // getting path to the file from command line argument
            File input = new File(path);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(input));  // Using buffered reader to read the contents of file

            Map<Character,Integer> map = new HashMap<>();

            String line;
            char key;

            // reading each line from the contents of file
            while ((line = bufferedReader.readLine())!=null) {

                // reading each character from the line
                for (int i = 0; i < line.length(); i++) {

                    // storing each character as key
                    key = line.charAt(i);

                    // if character exists already than increment the count in value else put 1.
                    if (map.containsKey(key))
                        map.put(key, map.get(key) + 1);
                    else
                        map.put(key, 1);
                }
            }
                File output = new File("assignmentsNew/src/main/java/jia7/output.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output));

                // writing each character and its occurrence count in output file
                for ( Map.Entry<Character, Integer> m:map.entrySet() ) {

                    bufferedWriter.write(m.getKey()+" : "+m.getValue());
                    bufferedWriter.newLine();

                 }

            System.out.println("Results written to output.txt file");

            bufferedReader.close();
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}

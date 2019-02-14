package jia7;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class CharacterCount {

    private static final Logger LOG = Logger.getLogger(CharacterCount.class.getName());
    private static final File OUTPUT_FILE = new File("assignmentsNew/src/main/java/jia7/OUTPUT_FILE.txt");

    /**
     * Reads the content of the file looping through each line and each character
     * Storing character as key and its count as value in map
     *
     * @param filePath input file path
     * @return Character Count HashMap
     * @throws IOException
     */
    private static Map<Character, Integer> getCharacterCount(String filePath) throws IOException {
        File inputFile = new File(filePath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));

        Map<Character, Integer> characterCountHashMap = new HashMap<>();

        String line;
        char key;

        while ((line = bufferedReader.readLine()) != null) {

            for (int i = 0; i < line.length(); i++) {

                key = line.charAt(i);

                // if character exists already than increment the count in value else put 1.
                if (characterCountHashMap.containsKey(key))
                    characterCountHashMap.put(key, characterCountHashMap.get(key) + 1);
                else
                    characterCountHashMap.put(key, 1);
            }
        }
        bufferedReader.close();

        return characterCountHashMap;
    }


    /**
     * Writes character and its in count in each line in output file
     * @param characterCountHashMap map containing key value as character and its count in input file
     * @throws IOException
     */
    private static void writeCharacterCountToFile(Map<Character, Integer> characterCountHashMap) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE));

        // writing each character and its occurrence count in OUTPUT_FILE file
        for (Map.Entry<Character, Integer> m : characterCountHashMap.entrySet()) {

            bufferedWriter.write(m.getKey() + " : " + m.getValue());
            bufferedWriter.newLine();

        }

        LOG.info("Results written to output.txt file");

        bufferedWriter.close();
    }


    public static void main(String[] args) {

        try {

            String path = args[0];

            Map<Character, Integer> characterCountHashMap = getCharacterCount(path);

            writeCharacterCountToFile(characterCountHashMap);

        } catch (Exception e) {
            LOG.info(e.getMessage());
        }


    }


}

import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;
import java.util.logging.Logger;

public class FileSearch {

    private static final File HOME_DIRECTORY = new File("/home");
    private static final Logger LOG = Logger.getLogger(FileSearch.class.getName());


    /**
     * printing absolute paths of files from the given list
     *
     * @param files list of files
     */
    private static void printAbsolutePathOfFiles(File[] files) {
        if (files == null)
            return;
        for (File file : files) {
            LOG.info(file.getAbsolutePath());
        }
    }

    /**
     * prints all the files matching the string searching recursively through sub directories.
     *
     * @param directory  directory to search for files
     * @param searchText search string for file search
     */
    private static void findMatchingFiles(File directory, String searchText) {

        FileFilter fileFilter = file -> {
            if (file.isDirectory()) {
                findMatchingFiles(file, searchText);
            } else {
                return file.getName().matches(".*" + searchText + ".*");
            }
            return false;
        };

        printAbsolutePathOfFiles(directory.listFiles(fileFilter));

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String searchText;

        LOG.info("Enter exit in the search to stop running the program");
        do {
            LOG.info("Enter your search");
            searchText = sc.next();
            if (searchText.equalsIgnoreCase("exit")) {
                break;
            }
            findMatchingFiles(HOME_DIRECTORY, searchText);
        } while (true);


    }
}

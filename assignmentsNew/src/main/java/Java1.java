import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class Java1 {


    /*
     * prints all the files matching the string
     *
     */
    static void findFiles(final String searchText){
        File homeDir = new File("/home/");
        FilenameFilter filter = (dir, name) -> name.matches("(.*)"+searchText+"(.*)");

        File[] files = homeDir.listFiles(filter);
        System.out.println("Files found "+files.length);

        for(int i=0;i<files.length;i++){
            String fileName = files[i].getAbsolutePath();
            System.out.println(fileName);
        }

    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        String searchText;
        boolean stop=false;
        do{
            System.out.println("Enter your search");
            searchText=sc.next();
            findFiles(searchText);
            System.out.println("Press 0 to stop or any number to continue");
        }while (sc.nextInt()!=0);



    }
}

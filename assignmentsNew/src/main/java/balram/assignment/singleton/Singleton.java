package balram.assignment.singleton;

public class Singleton {

    private static Singleton singleton = null;

    public String string;

    public static Singleton assignAndReturn(String string){

        if(singleton == null)
            singleton = new Singleton();
        singleton.string=string;

        return singleton;
    }

    public void printString(){
        System.out.println(string);
    }
}

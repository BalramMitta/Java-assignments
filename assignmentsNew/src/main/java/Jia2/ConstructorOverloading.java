package Jia2;

public class ConstructorOverloading {


    /**
     *  Constructor without arguments
     */
    ConstructorOverloading() {
        this("Greetings");
        System.out.println("Inside Constructor With No arguments");
    }


    /**
     *
     * Constructor with one argument
     * @param welcomeMessage
     */
    ConstructorOverloading(String welcomeMessage) {
        System.out.println("Inside Constructor with welcome message : " + welcomeMessage);
    }

    public static void main(String[] args) {

        ConstructorOverloading constructorOverloading = new ConstructorOverloading();

    }


}

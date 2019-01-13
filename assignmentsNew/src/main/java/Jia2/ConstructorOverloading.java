package Jia2;

public class ConstructorOverloading {




    //first constructor without arguments
    ConstructorOverloading(){
        this("Greetings");
        System.out.println("Inside First Constructor");
    }

    //second constructor with one argument
    ConstructorOverloading(String welcomeMessage){
        System.out.println("Inside Second Constructor : "+welcomeMessage);
    }

    public static void main(String[] args){

        ConstructorOverloading constructorOverloading = new ConstructorOverloading();

    }


}

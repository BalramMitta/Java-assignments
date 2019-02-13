package balram.assignment.main;

import balram.assignment.data.Data;
import balram.assignment.singleton.Singleton;

public class Main {


    public static void main(String[] args){

        Data data = new Data();
        data.printMemberVaribales();
        // data.printLocalVariables();

        Singleton singleton=Singleton.getSingletonWithString("String in singleton class");
        singleton.printString();
    }



}

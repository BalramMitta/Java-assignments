package Jia2;

public class ClassArrayInitialization {

    ClassArrayInitialization(String variable){
        System.out.println(variable);
    }

    public static void main(String[] args){

        ClassArrayInitialization[] classArrays=new ClassArrayInitialization[5];

        classArrays[0]=new ClassArrayInitialization("var1");
        classArrays[1]=new ClassArrayInitialization("var2");
        classArrays[2]=new ClassArrayInitialization("var3");
        classArrays[3]=new ClassArrayInitialization("var4");
        classArrays[4]=new ClassArrayInitialization("var5");

    }

}
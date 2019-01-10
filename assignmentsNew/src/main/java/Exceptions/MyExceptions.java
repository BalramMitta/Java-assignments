package Exceptions;

class NegativeValueException extends Exception{

    NegativeValueException(){
        super("NegativeValueException - cannot have negative values");
    }

}

class ZeroValueException extends Exception{

    ZeroValueException(){
        super("ZeroValueException - cannot have zeroes");
    }

}

class LimitExceededException extends Exception{

    LimitExceededException(){
        super("LimitExceededException - value cannot be more than 100");
    }

}


public class MyExceptions {

    void printArea(int l,int b){
        try {
            if (l < 0 || b < 0) {
                throw new NegativeValueException();
            }
            else if(l==0 || b==0){
                throw new ZeroValueException();
            }
            else if(l>100 || b>100){
                throw new LimitExceededException();
            }
            else {
                System.out.println("Area : "+l*b);
            }
        }
        catch (Exception e){
            System.out.println("Exception caught  \n"+e.getMessage());
        }
        finally {
            System.out.println("Inside Finally block");
        }
    }

    public static void main(String[] args){

        MyExceptions myExceptions = new MyExceptions();

        myExceptions.printArea(-1,4);
        myExceptions.printArea(6,0);
        myExceptions.printArea(104,88);
        myExceptions.printArea(12,9);

    }

}

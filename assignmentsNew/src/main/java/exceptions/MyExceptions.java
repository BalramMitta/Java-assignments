package exceptions;

import java.util.logging.Logger;

class NegativeValueException extends Exception {

    NegativeValueException() {
        super("NegativeValueException - cannot have negative values");
    }

}

class ZeroValueException extends Exception {

    ZeroValueException() {
        super("ZeroValueException - cannot have zeroes");
    }

}

class LimitExceededException extends Exception {

    LimitExceededException() {
        super("LimitExceededException - value cannot be more than 100");
    }

}


public class MyExceptions {

    Logger logger = Logger.getLogger(MyExceptions.class.getName());

    /**
     * Calculate area of rectangle
     * Throwing user defined exceptions
     * <p>
     * Throwing null pointer exception to check whether finally block executes and it does.
     *
     * @param length
     * @param breadth
     */
    void printAreaOfRectangle(int length, int breadth) {
        try {
            if (length < 0 || breadth < 0) {
                throw new NegativeValueException();
            } else if (length == 0 || breadth == 0) {
                throw new ZeroValueException();
            } else if (length > 100 || breadth > 100) {
                throw new LimitExceededException();
            } else {
                logger.info("Area : " + length * breadth);
//                throw new NullPointerException();
            }
        } catch (NegativeValueException | ZeroValueException | LimitExceededException e) {
            logger.info("Exception caught  \n" + e.getMessage());
        } finally {
            logger.info("Inside Finally block");
        }
    }

    public static void main(String[] args) {

        MyExceptions myExceptions = new MyExceptions();

        myExceptions.printAreaOfRectangle(-1, 4);
        myExceptions.printAreaOfRectangle(6, 0);
        myExceptions.printAreaOfRectangle(104, 88);
        myExceptions.printAreaOfRectangle(12, 9);

    }

}

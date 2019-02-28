package functions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Scanner;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class MatrixManipulationTest {


    @Test
    void testExpectedOutput1() {
        StringBuilder input = new StringBuilder();
        input.append("3 ");
        input.append("3 ");
        input.append("3 0 0 ");
        input.append("2 3 4 ");
        input.append("1 2 3 ");

        StringBuilder expected = new StringBuilder();
        expected.append("\n");
        expected.append("0 0 0 ");
        expected.append("2 0 0 ");
        expected.append("1 0 0 ");

        MatrixManipulation matrixManipulation = new MatrixManipulation();
        matrixManipulation.setScanner(new Scanner(input.toString()));
        matrixManipulation.makeRowAndColumnOfAllZeroElementsToZero();

        assertEquals(expected.toString(), matrixManipulation.buildMatrix());
    }

    @Test
    void testExpectedOutput2() {
        StringBuilder input = new StringBuilder();
        input.append("3 ");
        input.append("4 ");
        input.append("3 0 2 0 ");
        input.append("2 3 4 9 ");
        input.append("0 2 3 9 ");

        StringBuilder expected = new StringBuilder();
        expected.append("\n");
        expected.append("0 0 0 0 ");
        expected.append("0 0 4 0 ");
        expected.append("0 0 0 0 ");

        MatrixManipulation matrixManipulation = new MatrixManipulation();
        matrixManipulation.setScanner(new Scanner(input.toString()));
        matrixManipulation.makeRowAndColumnOfAllZeroElementsToZero();

        assertEquals(expected.toString(), matrixManipulation.buildMatrix());
    }

    @Test
    void testExpectedOutput3() {
        StringBuilder input = new StringBuilder();
        input.append("4 ");
        input.append("3 ");
        input.append("0 1 0 ");
        input.append("2 3 4 ");
        input.append("0 2 0 ");
        input.append("1 2 4 ");

        StringBuilder expected = new StringBuilder();
        expected.append("\n");
        expected.append("0 0 0 ");
        expected.append("0 3 0 ");
        expected.append("0 0 0 ");
        expected.append("0 2 0 ");

        MatrixManipulation matrixManipulation = new MatrixManipulation();
        matrixManipulation.setScanner(new Scanner(input.toString()));
        matrixManipulation.makeRowAndColumnOfAllZeroElementsToZero();

        assertEquals(expected.toString(), matrixManipulation.buildMatrix());
    }

    /**
     * check input mismatch exception caught and display warning
     */
    @Test
    void testInputMismatchException1() {
        final Logger logger = Logger.getLogger(MatrixManipulation.class.getName());
        StringBuilder input = new StringBuilder();
        input.append("3 ");
        input.append("a ");                             // a is not an integer
        input.append("3 0 0 ");
        input.append("2 3 4 ");
        input.append("1 2 3 ");

        MatrixManipulation matrixManipulation = new MatrixManipulation();
        matrixManipulation.setScanner(new Scanner(input.toString()));
        matrixManipulation.makeRowAndColumnOfAllZeroElementsToZero();

    }


    /**
     * check input mismatch exception caught and display warning
     */
    @Test
    void testInputMismatchException2() {
        final Logger logger = Logger.getLogger(MatrixManipulation.class.getName());
        StringBuilder input = new StringBuilder();
        input.append("3 ");
        input.append("3 ");
        input.append("3 0 0 ");
        input.append("2 a 4 ");                          // a is not an integer
        input.append("1 2 3 ");

        MatrixManipulation matrixManipulation = new MatrixManipulation();
        matrixManipulation.setScanner(new Scanner(input.toString()));
        matrixManipulation.makeRowAndColumnOfAllZeroElementsToZero();

    }

    /**
     * check if it displays warning if noOfRows is negative
     */
    @Test
    void testNoOfRowsNegative() {
        final Logger logger = Logger.getLogger(MatrixManipulation.class.getName());
        StringBuilder input = new StringBuilder();
        input.append("-3 ");                          // -3 is negative
        input.append("3 ");
        input.append("3 0 0 ");
        input.append("2 a 4 ");
        input.append("1 2 3 ");

        MatrixManipulation matrixManipulation = new MatrixManipulation();
        matrixManipulation.setScanner(new Scanner(input.toString()));
        matrixManipulation.makeRowAndColumnOfAllZeroElementsToZero();

    }

    /**
     * check if it displays warning if noOfColumns is negative
     */
    @Test
    void testNoOfColumnsNegative() {
        final Logger logger = Logger.getLogger(MatrixManipulation.class.getName());
        StringBuilder input = new StringBuilder();
        input.append("3 ");
        input.append("-3 ");                            // -3 is negative
        input.append("3 0 0 ");
        input.append("2 a 4 ");
        input.append("1 2 3 ");

        MatrixManipulation matrixManipulation = new MatrixManipulation();
        matrixManipulation.setScanner(new Scanner(input.toString()));
        matrixManipulation.makeRowAndColumnOfAllZeroElementsToZero();

    }

}
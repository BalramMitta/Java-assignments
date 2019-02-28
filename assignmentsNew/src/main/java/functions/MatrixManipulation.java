package functions;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Logger;

public class MatrixManipulation {

    private static final Logger LOG = Logger.getLogger(MatrixManipulation.class.getName());
    private Scanner scanner;
    private int[][] matrix;
    private int noOfRows;
    private int noOfColumns;
    private Set<Integer> rowsContainingZero = new HashSet<>();
    private Set<Integer> columnsContainingZero = new HashSet<>();


    /**
     * Going through function calls in a sequence
     * reading the inputs
     * ans finding where there are zeroes and
     * making the all the elements of rows and columns of zeroes to zero
     */
    public void makeRowAndColumnOfAllZeroElementsToZero() {
        handleInputs();
        findZeroesInMatrix();
        makeRowsZero();
        makeColumnsZero();
    }

    /**
     * Handles exceptions for inputs from console
     */
    private void handleInputs() {
        try {
            scanUserInputs();
        } catch (InputMismatchException e) {
            LOG.warning("Improper input");
        } catch (NegativeValueException e) {
            LOG.warning(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    /**
     * Calling functions to scan each inputs to be read from console
     *
     * @throws Exception
     */
    private void scanUserInputs() throws InputMismatchException, NegativeValueException {
        setNoOfRowsFromConsoleInput();
        setNoOfColumnsFromConsoleInput();
        setMatrixFromConsoleInput();
    }

    /**
     * getting no.of rows of matrix from console input and assign to noOfRows
     *
     * @throws NegativeValueException
     * @throws InputMismatchException
     */
    private void setNoOfRowsFromConsoleInput() throws NegativeValueException, InputMismatchException {
        LOG.info("Enter no.of rows of matrix");
        noOfRows = scanner.nextInt();
        if (noOfRows < 0) {
            throw new NegativeValueException("Number of rows cannot be negative");
        }
    }


    /**
     * getting no.of columns of matrix from console input and assign to noOfColumns
     *
     * @throws NegativeValueException
     * @throws InputMismatchException
     */
    private void setNoOfColumnsFromConsoleInput() throws NegativeValueException, InputMismatchException {
        LOG.info("Enter no.of columns of matrix");
        noOfColumns = scanner.nextInt();
        if (noOfColumns < 0) {
            throw new NegativeValueException("Number of columns cannot be negative");
        }
    }

    /**
     * Read input from the command line and
     * store values in 2d int array variable 'matrix' accordingly
     *
     * @throws InputMismatchException
     */
    private void setMatrixFromConsoleInput() throws InputMismatchException {
        matrix = new int[noOfRows][noOfColumns];
        LOG.info("Enter the elements for matrix");
        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < noOfColumns; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }

    /**
     * find the elements of matrix which are zero and
     * pass row index and column index of that element
     */
    private void findZeroesInMatrix() {
        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < noOfColumns; col++) {
                if (matrix[row][col] == 0) {
                    addRowAndColumnContainingZero(row, col);
                }
            }
        }
    }

    /**
     * Adds row index to the set rowsContainingZero
     * Adds column index to the set columnsContainingZero
     *
     * @param row row index
     * @param col column index
     */
    private void addRowAndColumnContainingZero(int row, int col) {
        rowsContainingZero.add(row);
        columnsContainingZero.add(col);
    }

    /**
     * Makes all the elements of rows which are there in the set rowsContainingZero to zero
     */
    private void makeRowsZero() {
        for (int row : rowsContainingZero) {
            makeAllTheElementsOfRowToZero(row);
        }
    }

    /**
     * Makes all the elements of columns which are there in the set columnsContainingZero to zero
     */
    private void makeColumnsZero() {
        for (int col : columnsContainingZero) {
            makeAllTheElementsOfColumnToZero(col);
        }
    }

    /**
     * Changes all the elements of given row to zero
     *
     * @param row row index of matrix
     */
    private void makeAllTheElementsOfRowToZero(int row) {
        for (int col = 0; col < noOfColumns; col++) {
            matrix[row][col] = 0;
        }
    }

    /**
     * Changes all the elements of given column to zero
     *
     * @param col column index of matrix
     */
    private void makeAllTheElementsOfColumnToZero(int col) {
        for (int row = 0; row < noOfRows; row++) {
            matrix[row][col] = 0;
        }
    }


    /**
     * prints the matrix
     */
    private void printMatrix() {
        LOG.info(this.buildMatrix());
    }


    /**
     * string builder used to making the string of matrix with rows and columns
     *
     * @return matrix in string format for printing
     */
    public String buildMatrix() {
        StringBuilder matrixBuilder = new StringBuilder();
        matrixBuilder.append("\n");
        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < noOfColumns; col++) {
                matrixBuilder.append(matrix[row][col] + " ");
            }
        }
        return matrixBuilder.toString();
    }


    public static void main(String[] args) {

        MatrixManipulation matrixManipulation = new MatrixManipulation();

        matrixManipulation.setScanner(new Scanner(System.in));

        matrixManipulation.makeRowAndColumnOfAllZeroElementsToZero();

        matrixManipulation.printMatrix();

    }


    /**
     * sets scanner
     *
     * @param scanner
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

}


/**
 * Space Complexity
 * for matrix O(n^2)
 * extra space for two hashsets which in worst case (noOfRows+noOfColumns) = O(m+n)
 * <p>
 * <p>
 * clean code list of things done
 * <p>
 * Functions should be as small as possible.
 * They should do only one thing.
 * Make the code read like a top-down narrative.
 * Make use of descriptive function names
 * The ideal number of arguments for a function is zero(niladic)
 * If block else block and etc blocks should contain only single line and that should be a function call.
 */
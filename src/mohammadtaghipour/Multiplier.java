package mohammadtaghipour;

import java.awt.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.Random;

/**
 * An instance of this class is used to multiply two n*n matrices with random values <br>
 * The constructor of this class gets a value for initializing the matrix size
 * @author Mohammad Taghipour
 * @version 1.0
 */
public class Multiplier {
    private final int[][] A;
    private final int[][] B;
    private final int[][] resultMatrix;
    private final Random random;
    private final String savingPath = System.getProperty("user.home") + "\\Desktop\\Result.txt";

    /**
     * @return the first matrix
     */
    public int[][] getA() {
        return A;
    }

    /**
     * @return the second matrix
     */
    public int[][] getB() {
        return B;
    }

    /**
     * @param matrixLength The length of matrices
     */
    public Multiplier(int matrixLength) {
        A = new int[matrixLength][matrixLength];
        B = new int[matrixLength][matrixLength];
        resultMatrix = new int[matrixLength][matrixLength];
        random = new Random();
    }

    /**
     * Call this method to initializing the matrices randomly
     */
    public void initializeMatrix() {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                A[i][j] = random.nextInt(100);
                B[i][j] = random.nextInt(100);
            }
        }
    }

    /**
     * Start multiplying A and B matrices
     */
    public void doMultiplication() {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                resultMatrix[i][j] = 0;
                for (int k = 0; k < resultMatrix.length; k++) {
                    resultMatrix[i][j] += A[i][k] * B[k][j];
                }
            }
        }
    }

    /**
     * Use this method to save the result of calculation in a .txt file
     */
    public void saveResultInTextFile() {
        File file = new File(savingPath);
        try {
            if (!file.exists())
                if (file.createNewFile() && file.setReadable(true)) {
                    System.out.println("File Created!");
                }
            System.out.println("Printing result...");
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.print(returnMatrixInString(resultMatrix));
            System.out.println("See result in : " + savingPath);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + " ==> Change the savingPath!");
        }
    }

    /**
     *
     * @param matrix Enter a matrix to print
     */
    public void printMatrix(int[][] matrix) {
        if (matrix == A)
            System.out.println("Matrix A:");
        else System.out.println("Matrix B:");
        for (int[] numbers : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(numbers[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private char[] returnMatrixInString(int[][] matrix) {
        StringBuilder container = new StringBuilder();
        for (int[] numbers : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                container.append(numbers[j]).append(" ");
            }
            container.append("\n");
        }
        return container.toString().toCharArray();
    }

    /**
     * Call this for opening the result file after multiplying
     */
    public void openFile() {
        try {
            System.out.println("Opening file...");
            File file = new File(savingPath);
            if (!Desktop.isDesktopSupported())
                return;
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) {
                desktop.open(file);
                System.out.println("File opened!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
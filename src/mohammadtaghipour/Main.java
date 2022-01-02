package mohammadtaghipour;

public class Main {
    //**** Mohammad Taghipour ****
    //**** Run this method for testing the Multiplier ****
    public static void main(String[] args) {
        Multiplier matrixMultiplier = new Multiplier(4);
        matrixMultiplier.initializeMatrix();
        matrixMultiplier.printMatrix(matrixMultiplier.getA());
        matrixMultiplier.printMatrix(matrixMultiplier.getB());
        matrixMultiplier.doMultiplication();
        matrixMultiplier.saveResultInTextFile();
        matrixMultiplier.openFile();
    }
}

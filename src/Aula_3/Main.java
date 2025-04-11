public class Main {
    public static void main(String[] args){
        System.out.println("Multiplicador de 2 Matrizes");
        MatrixMultiplier multiplier = new MatrixMultiplier();
        multiplier.getMatrixDimentionsCommandLine();

        if(multiplier.multiplicationIsPossible(multiplier.linesA, multiplier.columnsA, multiplier.linesB, multiplier.columnsB) == false)
            System.exit(0);

        float[][] matrixResult = new float[multiplier.linesA][multiplier.columnsB];

        multiplier.matrixA = multiplier.setMatrixCommandLine(multiplier.linesA, multiplier.columnsA);
        multiplier.matrixB = multiplier.setMatrixCommandLine(multiplier.linesB, multiplier.columnsB);

        matrixResult = multiplier.matrixMultiplier();

        multiplier.printMatrix(matrixResult);

        System.out.println("Programa terminando...");
        multiplier.scanner.close();
    }
}

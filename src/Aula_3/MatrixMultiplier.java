import java.util.Scanner;

public class MatrixMultiplier {
    float[][] matrixA, matrixB;
    int linesA, columnsA, linesB, columnsB;
    Scanner scanner = new Scanner(System.in);

    public void getMatrixDimentionsCommandLine(){
        // Matrix A
        System.out.println("Digite o numero de linhas de A:");
        linesA = scanner.nextInt();
        System.out.println("Digite o numero de colunas de A:");
        columnsA = scanner.nextInt();

        // Matrix A
        System.out.println("Digite o numero de linhas de B:");
        linesB = scanner.nextInt();
        System.out.println("Digite o numero de colunas de B:");
        columnsB = scanner.nextInt();

    }

    public boolean multiplicationIsPossible(int linesA, int columnsA, int linesB, int columnsB){
        boolean result = true;

        if(columnsA != linesB){
            result = false;
            System.out.println("Multiplicação impossível: (# colunas de A) != (# linhas de B)");
        }

        return result;
    }

    public float[][] matrixMultiplier() {
        float[][] matrixResult = new float[linesA][columnsB];
    
        for (int i = 0; i < linesA; i++) {
            for (int j = 0; j < columnsB; j++) {
                float sum = 0;
                for (int k = 0; k < columnsA; k++) {
                    sum += matrixA[i][k] * matrixB[k][j];
                }
                matrixResult[i][j] = sum;
            }
        }
    
        return matrixResult;
    }


    public float[][] setMatrixCommandLine(int lines, int columns) {
        System.out.println("Digite a matriz:");
        float[][] matrix = new float[lines][columns];

        for(int i = 0; i < lines; i++){
            for(int j = 0; j < columns; j++){
                matrix[i][j] = scanner.nextFloat();
            }
        }

        return matrix;
    }

    public void printMatrix(float[][] matrix){
        int lines = matrix.length;                 
        int columns = matrix[0].length;
        
        for(int i = 0; i < lines; i++){
            System.out.print("[ ");

            for(int j = 0; j < columns; j++){
                System.out.print(matrix[i][j] + " ");
            }

            System.out.print("] \n");
        }
    }

}
package sorting;

public class Main {
    public static void main(String[] args)
    {
        int[] int1 = {34, 5, 3, 7, 2, 0, 6, 3, -10, 34, 5, 8};
        int[] int2 = int1.clone();
        int[] int3 = int1.clone();

        Integer[] integer1 = Utility.int2Integer(int1);
        Integer[] integer2 = Utility.int2Integer(int2);
        Integer[] integer3 = Utility.int2Integer(int3);

        // Quicksort crescente
        Sorter<Integer> quicksort = new Sorter<>(Sorter.QUICKSORT);
        quicksort.sort(integer1);
        System.out.print("Integer Quicksort crescente: ");
        printArray(integer1);

        // Quicksort decrescente
        quicksort.sort(integer1, false);
        System.out.print("Integer Quicksort decrescente: ");
        printArray(integer1);

        // Mergesort crescente
        Sorter<Integer> mergesort = new Sorter<>(Sorter.MERGESORT);
        mergesort.sort(integer2);
        System.out.print("Integer Mergesort crescente: ");
        printArray(integer2);

        // Mergesort decrescente
        mergesort.sort(integer2, false);
        System.out.print("Integer Mergesort decrescente: ");
        printArray(integer2); 

        // Insertionsort crescente
        Sorter<Integer> insertionsort = new Sorter<>(Sorter.INSERTIONSORT);
        insertionsort.sort(integer3);
        System.out.print("Integer Insertionsort crescente: ");
        printArray(integer3);

        // Insertionsort decrescente
        insertionsort.sort(integer3, false);
        System.out.print("Integer Insertionsort decrescente: ");
        printArray(integer3);

        // Double
        double[] d1 = {2.1, 3.4, 1.2};
        Double[] double1 = Utility.double2Double(d1);

        Sorter<Double> doubleSorter = new Sorter<>(Sorter.QUICKSORT);
        doubleSorter.sort(double1);
        System.out.print("Double Quicksort crescente: ");
        printArray(double1);

        doubleSorter.sort(double1, false);
        System.out.print("Double Quicksort decrescente: ");
        printArray(double1);

        // String
        String[] s1 = {"banana", "uva", "maçã"};
        Sorter<String> stringSorter = new Sorter<>(Sorter.MERGESORT);
        stringSorter.sort(s1);
        System.out.print("String Mergesort crescente: ");
        printArray(s1);

        stringSorter.sort(s1, false);
        System.out.print("String Mergesort decrescente: ");
        printArray(s1);
    }

    // Método utilitário para imprimir arrays
    private static <T> void printArray(T[] arr) {
        for (T elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}

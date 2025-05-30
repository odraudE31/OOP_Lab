package sorting;

public class Sorter {

    public static final int QUICKSORT = 1;
    public static final int MERGESORT = 2;
    public static final int INSERTIONSORT = 3;

    private int method; // algoritmo de ordenação

    public Sorter(int method) {
        this.method = method;
    }

    public void sort(int a[]) {
        Sort sorter;

        switch (method) {
            case Sorter.QUICKSORT: 
                sorter = new Quicksort();
                break;
            case Sorter.MERGESORT: 
                sorter = new Mergesort();
                break;
            case Sorter.INSERTIONSORT:
                sorter = new Insertionsort();
                break;
            default:
                throw new IllegalArgumentException("Método de ordenação inválido: " + method);
        }
        sorter.sort(a);
    }


    // Main
    public static void main(String[] args)
    {
        int[] inteiros1 = {34, 5, 3, 7, 2, 0, 6, 3, -10, 34, 5, 8};
        int[] inteiros2 = {34, 5, 3, 7, 2, 0, 6, 3, -10, 34, 5, 8};
        int[] inteiros3 = {34, 5, 3, 7, 2, 0, 6, 3, -10, 34, 5, 8};
        
        Sorter quicksort = new Sorter(Sorter.QUICKSORT);
        Sorter mergesort = new Sorter(Sorter.MERGESORT);
        Sorter insertionsort = new Sorter(Sorter.INSERTIONSORT);

        System.out.println("Quicksort");
        quicksort.sort(inteiros1);
        for (int elem : inteiros1)
            System.out.print(elem + " ");
        System.out.println();

        System.out.println("Mergesort");
        mergesort.sort(inteiros2);
        for (int elem : inteiros2)
            System.out.print(elem + " ");
        System.out.println();

        System.out.println("Insertionsort");
        insertionsort.sort(inteiros3);
        for (int elem : inteiros3)
            System.out.print(elem + " ");
        System.out.println();

    }    
}
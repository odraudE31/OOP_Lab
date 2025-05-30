package sorting;

public class Sorter<T extends Comparable<T>> {

    public static final int QUICKSORT = 1;
    public static final int MERGESORT = 2;
    public static final int INSERTIONSORT = 3;

    private int method; // sorting algorthm

    public Sorter(int method) {
        this.method = method;
    }

    public void sort(T[] a) {
        sort(a, true); // default: growing
    }

    public void sort(T[] a, boolean ascending) {
        Sort<T> sorter;
        switch (method) {
            case Sorter.QUICKSORT:
                sorter = new Quicksort<>();
                break;
            case Sorter.MERGESORT:
                sorter = new Mergesort<>();
                break;
            case Sorter.INSERTIONSORT:
                sorter = new Insertionsort<>();
                break;
            default:
                throw new IllegalArgumentException("Método de ordenação inválido: " + method);
        }

        if (sorter instanceof Quicksort) {
            ((Quicksort<T>) sorter).sort(a, ascending);
        } else if (sorter instanceof Mergesort) {
            ((Mergesort<T>) sorter).sort(a, ascending);
        } else if (sorter instanceof Insertionsort) {
            ((Insertionsort<T>) sorter).sort(a, ascending);
        }
    }
}
package sorting;

public class Quicksort<T extends Comparable<T>> extends Sort<T> {
    public T[] sort(T[] a, boolean ascending) {
        if (!sorting.Utility.isHomogeneous(a)) {
            throw new IllegalArgumentException("O array contém elementos de tipos diferentes.");
        }
        quicksort(a, 0, a.length - 1, ascending);
        return a;
    }

    @Override
    public T[] sort(T[] a) {
        return sort(a, true);
    }

    private void quicksort(T[] a, int i, int j, boolean ascending) {
        if (i >= j) return;

        int pivot = partition(a, i, j, ascending);

        quicksort(a, i, pivot - 1, ascending);
        quicksort(a, pivot + 1, j, ascending);
    }

    private int partition(T[] array, int start, int end, boolean ascending) {
        T pivot = array[end];
        int balancePoint = start;

        for (int i = start; i < end; i++) {
            boolean condition = ascending
                ? array[i].compareTo(pivot) <= 0
                : array[i].compareTo(pivot) >= 0;
            if (condition) {
                T tmp = array[i];
                array[i] = array[balancePoint];
                array[balancePoint] = tmp;
                balancePoint++;
            }
        }

        T tmp = array[end];
        array[end] = array[balancePoint];
        array[balancePoint] = tmp;

        return balancePoint;
    }
}

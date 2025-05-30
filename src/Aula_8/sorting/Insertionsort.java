package sorting;

public class Insertionsort<T extends Comparable<T>> extends Sort<T> {

    public T[] sort(T[] a, boolean ascending) {
        if (!sorting.Utility.isHomogeneous(a)) {
            throw new IllegalArgumentException("O array contém elementos de tipos diferentes.");
        }
        insertionsort(a, ascending);
        return a;
    }

    private void insertionsort(T[] a, boolean ascending) {
        for (int i = 1; i < a.length; i++) {
            T x = a[i];
            int j = i - 1;
            while (j >= 0 && (ascending ? a[j].compareTo(x) > 0 : a[j].compareTo(x) < 0)) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = x;
        }
    }

    @Override
    public T[] sort(T[] a) {
        return sort(a, true);
    }
}

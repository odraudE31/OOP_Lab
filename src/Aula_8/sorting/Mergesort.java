package sorting;

public class Mergesort<T extends Comparable<T>> extends Sort<T> {

    public T[] sort(T[] a, boolean ascending) {
        if (!sorting.Utility.isHomogeneous(a)) {
            throw new IllegalArgumentException("O array contém elementos de tipos diferentes.");
        }
        mergesort(a, 0, a.length - 1, ascending);
        return a;
    }

    @Override
    public T[] sort(T[] a) {
        return sort(a, true);
    }

    private void mergesort(T[] a, int i, int j, boolean ascending) {
        if (j <= i) return;
        int midpoint = (i + j) / 2;
        mergesort(a, i, midpoint, ascending);
        mergesort(a, midpoint + 1, j, ascending);
        merge(a, i, midpoint, j, ascending);
    }

    private void merge(T[] a, int start, int mid, int end, boolean ascending) {
        Object[] aux = new Object[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (ascending ? a[i].compareTo(a[j]) <= 0 : a[i].compareTo(a[j]) >= 0) {
                aux[k++] = a[i++];
            } else {
                aux[k++] = a[j++];
            }
        }
        while (i <= mid) {
            aux[k++] = a[i++];
        }
        while (j <= end) {
            aux[k++] = a[j++];
        }
        for (i = start; i <= end; i++)
            a[i] = (T) aux[i - start];
    }
}

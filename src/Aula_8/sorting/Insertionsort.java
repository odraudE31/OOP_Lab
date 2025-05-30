package sorting;

public class Insertionsort extends Sort{

    @Override
    public int[] sort(int[] a) {
        insertionsort(a);
        return a;
    }

    private void insertionsort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int x = a[i];
            int j = i - 1;
            for (; j >= 0 && a[j] > x; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = x;
        }
    }
}

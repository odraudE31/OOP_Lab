package sorting;

public class Quicksort extends Sort {
    @Override
    public int[] sort(int[] a) {
        quicksort(a, 0, a.length - 1);
        return a;
    }

    private void quicksort(int[] a, int i, int j) {
        if (i >= j) return;

        int pivot = partition(a, i, j);

        quicksort(a, i, pivot - 1);
        quicksort(a, pivot + 1, j);
    }

    private int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int balancePoint = start; 

        for (int i = start; i < end; i++) 
            if(array[i] <= pivot) {
                int tmp = array[i];
                array[i] = array[balancePoint];
                array[balancePoint] = tmp;
                balancePoint++;
        }

        int tmp = array[end];
        array[end] = array[balancePoint];
        array[balancePoint] = tmp;

        return balancePoint;
    }    
}

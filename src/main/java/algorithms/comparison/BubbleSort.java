package  algorithms.comparison;

import test.BaseTemplate;

public class BubbleSort<T extends Comparable<T>> extends BaseTemplate<T> {
    @Override
    public void sort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (less(arr[j + 1], arr[j])) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

}
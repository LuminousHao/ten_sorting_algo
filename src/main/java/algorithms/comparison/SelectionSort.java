package  algorithms.comparison;

import test.BaseTemplate;

public class SelectionSort<T extends Comparable<T>> extends BaseTemplate<T> {
    @Override
    public void sort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if(less(arr[j],arr[minIndex])){
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swap(arr,i,minIndex);
            }
        }
    }
}
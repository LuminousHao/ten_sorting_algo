package  algorithms.comparison;

import test.BaseTemplate;

public class InsertionSort<T extends Comparable<T>> extends BaseTemplate<T> {
    @Override
    public void sort(T[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            T key = arr[i];
            int j = i - 1;
            while(j >= 0 && less(key,arr[j])){
                //arr[j + 1] = arr[j];
                swap(arr,j,j + 1);
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
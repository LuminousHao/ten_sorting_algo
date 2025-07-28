package  algorithms.comparison;

import test.BaseTemplate;

public class QuickSort<T extends Comparable<T>> extends BaseTemplate<T> {
    @Override
    public void sort(T[] arr) {
        int l = 0;
        int r = arr.length - 1;
        quickSort(arr,l,r);

    }

    private void quickSort(T[] arr,int left,int right){
        if(left < right){
            int pivotIndex = partition(arr,left,right);
            quickSort(arr,pivotIndex + 1,right);
            quickSort(arr,left,pivotIndex - 1);
        }
    }

    private int partition(T[] arr,int left,int right){
        T pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if(less(arr[j],pivot)){
                i++;
                if(i != j){
                    swap(arr,j,i);
                }
            }
        }
        swap(arr,i + 1,right);
        return i + 1;
    }
}
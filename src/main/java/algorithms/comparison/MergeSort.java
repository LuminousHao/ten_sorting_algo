package  algorithms.comparison;

import test.BaseTemplate;

import java.lang.reflect.Array;

public class MergeSort<T extends Comparable<T>> extends BaseTemplate<T> {
    @Override
    public void sort(T[] arr) {
        if(arr == null || arr.length <= 1){return;}
        //初始化辅助空间
        T[] temp = (T[]) new Comparable[arr.length];
        mergeSort(arr,temp,0, arr.length - 1);

    }

    private void mergeSort(T[] arr,T[] temp,int left,int right){
        if(left < right) {
            int mid = left + ((right - left) >> 1);
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }

    }

    private void merge(T[] arr,T[] temp,int left,int mid,int right){
        System.arraycopy(arr, left, temp, left, right - left + 1);
        int k = left;
        int p1 = left;
        int p2 = mid + 1;
        while(p1 <= mid && p2 <= right){
            arr[k++] = less(temp[p1],temp[p2]) ? temp[p1++] : temp[p2++];
        }
        while(p1 <= mid){
            arr[k++] = temp[p1++];
        }
        while(p2 <= right){
            arr[k++] = temp[p2++];
        }
    }
}
package test;

import algorithms.comparison.*;
import utils.SortValidator;

import java.util.Arrays;

public abstract class BaseTemplate<T extends Comparable<T>> {
    // 抽象排序方法，子类必须实现
    public abstract void sort(T[] arr);

    // 交换辅助方法
    protected void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 比较辅助方法
    protected boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }


    // 主测试方法
    public static void main(String[] args) {

        //自定义数据
        Double[] customData = {3.3,10.0,1.1,9.9,4.4,8.8,6.6,7.7};
        BaseTemplate<Double> doubleSorter = new MergeSort<>();
        doubleSorter.sort(customData);
        System.out.println(Arrays.toString(customData));

//        // 示例：测试BubbleSort
//        BaseTemplate<Integer> sorter = new BubbleSort<>();
//
//        // 生成测试数据
//        Integer[] testData = SortValidator.generateRandomArray(10_000, 0, 100_000);
//
//        // 测试性能并验证结果
//        SortValidator.PerformanceResult result =
//                SortValidator.testPerformance(sorter, testData.clone(), true);
//        System.out.println("=========");
//        System.out.println("--- Sorting Algorithm Performance ---");
//        System.out.println("Algorithm: " + sorter.getClass().getSimpleName());
//        System.out.println(result);
//        System.out.println("------------------------------------");
    }
}
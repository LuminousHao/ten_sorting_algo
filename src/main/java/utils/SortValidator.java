package utils;

import test.BaseTemplate;

import java.util.Random;

public class SortValidator {
    // 验证排序是否正确
    public static <T extends Comparable<T>> boolean validateSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    // 生成随机数组
    public static Integer[] generateRandomArray(int size, int min, int max) {
        Random random = new Random();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = min + random.nextInt(max - min + 1);
        }
        return arr;
    }

    // 生成近乎有序的数组
    public static Integer[] generateNearlySortedArray(int size, int swapTimes) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        Random random = new Random();
        for (int i = 0; i < swapTimes; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
        return arr;
    }

    // 性能测试
    public static <T extends Comparable<T>> PerformanceResult testPerformance(
            BaseTemplate<T> sorter, T[] arr, boolean validate) {

        long startTime = System.nanoTime();
        sorter.sort(arr);
        long endTime = System.nanoTime();

        boolean isValid = true;
        if (validate) {
            isValid = validateSort(arr);
        }

        return new PerformanceResult(
                endTime - startTime,
                isValid,
                arr.length
        );
    }

    // 性能结果记录类
    public static class PerformanceResult {
        public final long elapsedTime; // 纳秒
        public final boolean isValid;
        public final int dataSize;

        public PerformanceResult(long elapsedTime, boolean isValid, int dataSize) {
            this.elapsedTime = elapsedTime;
            this.isValid = isValid;
            this.dataSize = dataSize;
        }

        @Override
        public String toString() {
            return String.format(
                    "Data: %d items | Valid: %b | Time: %.3f ms",
                    dataSize, isValid, elapsedTime / 1_000_000.0
            );
        }
    }
}
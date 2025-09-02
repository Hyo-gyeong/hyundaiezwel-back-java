package f_bruteforce;

import java.util.Arrays;

import util.SortUtil;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = SortUtil.createRandomIntArray(100000);
        SortUtil.checkTime(() -> {
            selectionSort(arr);
            // System.out.println(Arrays.toString(arr));
        });
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            int minIndex = indexOfMin(arr, i);
            SortUtil.swap(arr, i, minIndex);
        }

    }

    private static int indexOfMin(int[] arr, int pointer) {
        int min = pointer;
        for (int i = pointer+1; i < arr.length; i++){
            if (arr[min] > arr[i]){
                min = i;
            }
        }
        return min;
    }
}

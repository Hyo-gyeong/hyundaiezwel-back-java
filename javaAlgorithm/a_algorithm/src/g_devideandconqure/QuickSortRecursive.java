package g_devideandconqure;

import java.util.Arrays;

import util.SortUtil;

public class QuickSortRecursive {
    public static void main(String[] args) {
        // int[] arr = {11,3,5,72,9,2,4,6,8,10};
        int[] arr = SortUtil.createRandomIntArray(100);

        SortUtil.checkTime(() -> {
            quickSort(arr, 0, arr.length-1);
            System.out.println(Arrays.toString(arr));
        });
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right){
            return;
        }
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot-1);
        quickSort(arr, pivot+1, right);
    }

    public static int partition(int[] arr, int first, int last){
        int pivotElement = arr[first]; // pivot을 정하는 알고리즘도 있지만 편의상 맨 앞의 요소로 결정
        int lp = first;
        int rp = last;

        while (true){
            while (lp < last && arr[lp] <= pivotElement){
                lp++;
            }
            while (rp > first && arr[rp] > pivotElement){
                rp--;
            }
            if (lp >= rp){
                break;
            }
            // 정렬에 위배되는 상태를 만나면
            SortUtil.swap(arr, lp, rp); // swap하고
            // pointer 옮겨줌
            lp++;
            rp--;
        }

        SortUtil.swap(arr, first, rp); // pivot을 가운데 위치로
        return rp;
    }
}

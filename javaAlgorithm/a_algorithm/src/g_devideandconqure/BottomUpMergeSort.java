package g_devideandconqure;

import java.util.Arrays;

import util.SortUtil;

// bottom up : 상향식
// 가장 간단하고 작은 문제를 해결 후 그 해답을 더해 최종적으로 문제 해결
// 시작점 : 가장 작은 문제 (길이가 1인 두 배열 병합)
// 진행 방향 : 부분 -> 전체
public class BottomUpMergeSort {
    public static void main(String[] args) {
        int[] arr = {11,3,5,7,9,2,4,6,8,10};

        SortUtil.checkTime(() -> {
            // mergeSort(arr);
            // System.out.println(Arrays.toString(arr));
            mergeSort(SortUtil.createRandomIntArray(100000000));
        });
    }
    
    private static void mergeSort(int[] arr) {
        int n = arr.length;
        // size = 현재 병합할 부분 배열의 길이
        for (int size = 1; size < n; size *= 2){
            // left = 첫 번째 부분 배열의 시작 인덱스
            for (int left = 0; left < n-1; left += 2*size){
                int mid = Math.min(left + size - 1, n-1);
                // right : 두 번째 부분 배열의 끝 인덱스
                int right = Math.min(left + 2*size -1 , n-1);
                merge(arr, left, mid, right);
            }
        }
    }

    static void merge(int[] arr, int left, int mid, int right){
        int lSize = mid - left + 1; // 0 포함
        int rSize = right - mid;

        if (rSize == 0){
            return;
        }

        int[] leftArr = new int[lSize];
        int[] rightArr = new int[rSize];

        for (int i = 0; i < lSize; i++){
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < rSize; i++){
            rightArr[i] = arr[mid + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = left;
        while (i < lSize && j < rSize){
            if (leftArr[i] < rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < lSize){
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < rSize){
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}

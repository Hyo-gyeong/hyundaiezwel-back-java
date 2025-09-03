package g_devideandconqure;

import java.util.Arrays;

import util.SortUtil;

// top-down방식
// 커다란 문제를 작은 부분으로 분할하며 해결
// divide(분할) comquer(정복) combine(병합)
// 시작점 : 전체 배열
// 진행 방향 : 전체 배열 -> 분할 -> 정복 -> 병합
public class MergeSort {
    public static void main(String[] args) {
        // int[] a = {1,3,5,7,9};
        // int[] b = {2,4,6,8,10};

        // int[] res = merge(a,b);
        // System.out.println(Arrays.toString(res));

        int[] arr = {11,3,5,7,59,2,4,6,8,10};

        // SortUtil.checkTime(() -> System.out.println(Arrays.toString(mergeSort(arr))));
        SortUtil.checkTime(() -> mergeSort(SortUtil.createRandomIntArray(100000000)));
    }

    private static int[] mergeSort(int[] arr) {
        int n = arr.length;
        if (n <= 1){
            return arr;
        }

        int mid = n/2;
        int[] arr1 = (int[]) mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] arr2 = (int[]) mergeSort(Arrays.copyOfRange(arr, mid, n));
        return merge(arr1, arr2);
    }

    private static int[] merge(int[] a, int[] b) { // 두 배열을 오름차순으로 합침. 전체 정렬은 되지 않음
        int[] res = new int[a.length+b.length];
        int p1 = 0;
        int p2 = 0;
        int idx = 0;

        while (p1 < a.length && p2 < b.length){ // a,b 길이가 같다는 보장이 없음
            if (a[p1] < b[p2]){
                res[idx] = a[p1];
                p1++;
            } else {
                res[idx] = b[p2];
                p2++;
            }
            idx++;
        }
        // a,b 중 남은 배열을 전부 결과 배열에 옮김
        while (p1 < a.length){
            res[idx] = a[p1];
            p1++;
            idx++;
        }
        while (p2 < b.length){
            res[idx] = b[p2];
            p2++;
            idx++;
        }
        return res;
    }
}

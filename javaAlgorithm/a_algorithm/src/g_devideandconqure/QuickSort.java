package g_devideandconqure;

import java.util.Arrays;
import java.util.Stack;

import util.SortUtil;

public class QuickSort {
    public static void main(String[] args) {
        // int[] arr = SortUtil.createRandomIntArray(100);
        int[] arr = {5,4,6,3,7,2,8,1,9};

        SortUtil.checkTime(() -> {
            quickSort(arr, 0, arr.length-1);
            System.out.println(Arrays.toString(arr));
        });
    }

    public static void quickSort(int[] arr, int left, int right) {
        // stack 사용
        Stack<int[]> stack = new Stack<>();
        int[] element = {left, right};
        stack.push(element); // 처음에는 모든 배열 범위를 넣음
        // * 배열을 정렬하는 것이므로 주소값이 변하지 않기 때문에 정렬할 배열을 주고 받을 필요 없음
        while (!stack.isEmpty()){
            int[] item = stack.pop(); // stack에 있는 배열을 꺼내서
            int l = item[0]; // 왼쪽 인덱스를 꺼냄
            int r = item[1]; // 오른쪽 인덱스를 꺼냄
            int pivot = partition(arr, l, r); // 왼쪽 인덱스부터 오른쪽 인덱스까지 정렬 후 pivot(=가운데 인덱스)값을 받아옴
            // pivot은 자리를 정한 것. pivot 왼쪽, 오른쪽을 정렬하면 됨
            if (l < pivot-1){ // pivot을 기준으로 왼쪽 배열을 정렬하도록 stack에 추가
                stack.push(new int[] {l, pivot-1});
            }
            if (r > pivot+1){ // pivot을 기준으로 오른쪽 배열을 정렬하도록 stackdp 추가
                stack.push(new int[] {pivot+1, r});
            }
        }    
    }

    public static int partition(int[] arr, int first, int last){ // first~last 구간의 arr를 정렬하고 가운데 값의 index반환
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

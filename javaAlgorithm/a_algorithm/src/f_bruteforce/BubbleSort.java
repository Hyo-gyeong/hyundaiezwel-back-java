package f_bruteforce;

import java.util.Arrays;

import util.SortUtil;
import util.Timer;

public class BubbleSort{
    public static void main(String[] args) {
        int[] arr = SortUtil.createRandomIntArray(100000);
        // System.out.println(Arrays.toString(arr));

        // 함수형 프로그래밍을 지원하는 언어에서 함수는 1급 객체
        // 1급 객체 : 값으로 다루어질 수 있다
        // => 반환값, 인자, 변수에 할당 가능

        // 자바는 함수가 1급 객체가 앙님
        // 자바의 람다는 함수가 1급 객체처럼 보일 수 있도록 syntax sugar
        // SortUtil.checkTime(() -> bubbleSort(arr)); // 인터페이스 내 함수가 단 하나라면 람다로 사용 가능
                                                    // 매개변수 x, 반환값 x
        /* 위와 같은 역할
        SortUtil.checkTime(new Timer(){
            @Override
            public void measure(){
                bubbleSort(arr);
            }
        });
        */
        
    }

    private static void bubbleSort(int[] arr) {
        for (int k = 0; k < arr.length; k++){
            for (int j = 0; j < arr.length-1; j++){
                if (arr[j] > arr[j+1]){
                    SortUtil.swap(arr, j, j+1);
                }
            }
        }
    }

    // upgrade
    private static void bubbleSort2(int[] arr) {
        for (int k = 1; k <= arr.length; k++){
            boolean notSwap = true;
            for (int j = 0; j < arr.length-k; j++){ // 항상 큰 값이 차례대로 맨 끝에 모이게 되므로 반복횟수 줄임
                if (arr[j] > arr[j+1]){
                    SortUtil.swap(arr, j, j+1);
                    notSwap = false;
                }
            }
            if (notSwap){ // 중간에 정렬이 되면 정렬 멈춤
                break;
            }
        }
    }

}

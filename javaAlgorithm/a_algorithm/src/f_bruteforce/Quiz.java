package f_bruteforce;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        // q1(5);
        q2(9);
    }

    // 종말의 수란 어떤 수에 6이 적어도 3개 이상 연속으로 들어가는 수, N번째 종말의 수 반환 (test case 1. 입력값 : 5, 결과 4666)
    private static void q1(int n) {
        int cnt = 0;
        int number = 666;
        while (true){
            if (countSix(number) >= 3){
                cnt++;
            }
            if (cnt == n){
                System.out.println(number);
                return;
            }
            number++;
        }
    }

    private static int countSix(int number) {
        int cnt = 0;
        while (number > 0){
            if (number % 10 == 6){
                cnt++;
            }
            number /= 10;
        }
        return cnt;
    }

    // 일곱 난쟁이
    private static void q2(int input) {
        int[] inputArr = new int[input];
        int sum = 0;
        for (int i = 0; i < input; i++){
            System.out.print("입력"+(i+1)+": ");
            inputArr[i] = new Scanner(System.in).nextInt();
            sum += inputArr[i];
        }
        for (int i = 0; i < input; i++){
            for (int j = 0; j < input; j++){
                if (i == j){
                    continue;
                }
                if (sum - inputArr[i] - inputArr[j] == 100){
                    printArr(inputArr, i, j, input);
                    return;
                }
            }
        }
    }

    private static void printArr(int[] inputArr, int x1, int x2, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++){
            if (i != x1 && i != x2)
                list.add(inputArr[i]);
        }
        list.sort(null);
        System.out.println(list.toString());
    }
}

package bruteforce;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2 {
    // 일곱난쟁이
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inputArr = new int[9];
        int sum = 0;
        for (int i = 0; i < inputArr.length; i++){
            System.out.print("입력"+(i+1)+": ");
            inputArr[i] = sc.nextInt();
            sum += inputArr[i];
        }
        for (int i = 0; i < inputArr.length; i++){
            for (int j = 0; j < inputArr.length; j++){
                if (i == j){
                    continue;
                }
                if (sum - inputArr[i] - inputArr[j] == 100){
                    printArr(inputArr, i, j, inputArr.length);
                    return;
                }
            }
        }
        sc.close();
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

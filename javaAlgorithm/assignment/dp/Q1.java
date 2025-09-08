package dp;

import java.util.Scanner;

public class Q1 {
    // 연속된 숫자 중 가장 큰 합
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("배열을 입력하세요(구분자 ,) : ");
        String[] arr = sc.nextLine().replaceAll(" ", "").split(",");

        int max = Integer.parseInt(arr[0]);
        int sum = Integer.parseInt(arr[0]);
        int i = 1;
        while (i < arr.length){
            int num = Integer.parseInt(arr[i]);
            sum = Math.max(num, sum+num); // 이전 값에 이어붙일지, 새로 시작할지 결정 - 연속된 수의 합 중 최대가 되는 것을 방해하는 배열을 떼어낼 수 있음
            max = Math.max(sum, max); // 앞서 계산해온 sum의 값중 가장 큰 값을 유지
            i++;
        }
        System.out.print(max);
        sc.close();
    }
}

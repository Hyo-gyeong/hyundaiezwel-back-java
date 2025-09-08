package divideandconquer;

import java.util.Scanner;

public class Q1 {
    // 거듭제곱의 최적화
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("A값을 입력하세요: ");
        int a = sc.nextInt();
        System.out.print("B값을 입력하세요: ");
        int b = sc.nextInt();
        System.out.println(power(a, b));

        sc.close();
    }

    private static long power(int a, int b) {
        if (b == 1){
            return a;
        }
        if (b % 2 == 0){
            return power(a, b/2) * power(a, b/2);
        } else {
            return power(a, b/2) * power(a, b/2) * a;
        }
    }
}

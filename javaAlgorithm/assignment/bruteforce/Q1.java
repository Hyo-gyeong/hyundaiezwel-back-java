package bruteforce;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("몇 번째 종말의 수를 구할까요? : ");
        int n = sc.nextInt();
        
        int num = 666;
        int cntN = 1;
        while (cntN < n){
            num++;
            int cntSix = countSix(num);
            if (cntSix >= 3){
                cntN++;
            }
        }
        System.out.println(num);

        sc.close();
    }

    private static int countSix(int number){
        int cnt = 0;
        while (number > 0){
            if (number%10 == 6){
                cnt++;
            }
            number /= 10;
        }
        return cnt;
    }
}

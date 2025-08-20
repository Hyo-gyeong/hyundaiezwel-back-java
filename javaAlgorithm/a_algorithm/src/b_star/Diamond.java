package b_star;

import java.util.Scanner;

public class Diamond {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("입력값 : ");
        int input = sc.nextInt();

        for (int i = 1; i <= input; i++){
            int space = input+1-i;
            while (space > 0){
                System.out.print(" ");
                space--;
            }
            // 별 사이 공백이 있는 경우 : 별의 최대 개수가 입력값과 같음
            // for (int j = 0; j < i; j++){
            //     System.out.print("* ");
            // }

            // 별 사이 공백이 없는 경우 : 별의 최대 개수가 입력값*2-1
            for (int j = 0; j < i*2-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = input-1; i >= 0; i--){
            int space = input+1-i;
            while (space > 0){
                System.out.print(" ");
                space--;
            }
            // 별 사이 공백이 있는 경우
            // for (int j = i; j > 0; j--){
            //     System.out.print("* ");
            // }

            // 별 사이 공백이 없는 경우
            for (int j = i*2-1; j > 0; j--){
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}

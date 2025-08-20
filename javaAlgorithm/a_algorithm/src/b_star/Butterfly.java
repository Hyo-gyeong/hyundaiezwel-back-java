package b_star;

import java.util.Scanner;

public class Butterfly {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("입력값 : ");
        int input = sc.nextInt();
        for (int i = 1; i <= input; i++){
            for (int j = 0; j < i; j++){
                System.out.print("* ");
            }
            int space = (input-i)*4;
            while (space > 0){
                System.out.print(" ");
                space--;
            }
            for (int j = 0; j < i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = input-1; i >= 0; i--){
            for (int j = i; j > 0; j--){
                System.out.print("* ");
            }
            int space = (input-i)*4;
            while (space > 0){
                System.out.print(" ");
                space--;
            }
            for (int j = i; j > 0; j--){
                System.out.print("* ");
            }
            System.out.println();
        }
        sc.close();
    }
}

package package2;

import java.util.Scanner;

public class WhileEx {
  public static void main(String[] args) {
    // 사용자가 숫자 7 입력할 때까지 계속 반복 입력
    Scanner sc = new Scanner(System.in);
    System.out.print("7을 입력하세요: ");
    int input = sc.nextInt();

    while (input != 7){
      System.out.println("7이 아닙니다. 7을 입력하세요: ");
      input = sc.nextInt();
    }

    sc.close();
  }
}
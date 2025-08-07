package package2;

import java.util.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reap {
  public static void main(String[] args) {
    int sum = 0;
    for (int i = 1; i <= 100; i++){
      sum += i;
    }
    System.err.println(sum);

    Scanner sc = new Scanner(System.in);
    int dan = sc.nextInt();
    System.out.println(dan + "단을 출력합니다.");
    for (int i = 1; i <= 9; i++){
      System.out.println(dan + " * " + i + " = " + (dan*i));
    }

    sc.close();
  }
}

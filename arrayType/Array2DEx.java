package arrayType;

import java.util.Scanner;

public class Array2DEx {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[][] arr = { { "chair", "의자" }, { "computer", "컴퓨터" }, { "integer", "정수" } };

    for (int i = 0; i < arr.length; i++) {
      System.out.print("Q" + (i + 1) + ". " + arr[i][0] + "의 뜻은? : ");
      String input = sc.next();
      String answer = arr[i][1];
      
      if (input.equals(answer)) {
        System.out.println("정답입니다.");
      } else {
        System.out.println("틀렸습니다. 정답은 " + answer + "입니다.");

      }
    }
    sc.close();
  }
}
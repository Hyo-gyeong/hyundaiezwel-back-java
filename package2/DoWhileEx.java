package package2;

import java.util.Scanner;

public class DoWhileEx {
  public static void main(String[] args) {
    // 입력되는 번호에 따라 해당 과목을 출력하는 프로그램
    Scanner sc = new Scanner(System.in);
    int input;
    String answer;
    // String: 메모리 최적화를 위해 중복된 문자열을 피하려고 설계된 상수 풀(Constant Pool)에 저장되는 불변 객체
    //       : 값을 변경할 때마다 새로운 객체가 생성됨.
    // StringBuilder: 가변 객체, 값을 변경할 때 기존 객체에서 직접 수정됨.

    System.out.println("과정 안내 프로그램");
    do {
      System.out.print("\n1~4 번호 입력 : ");
      input = sc.nextInt();
      switch (input) {
        case 1: 
          System.out.println("Java 프로그래밍");
          break;
        case 2: 
          System.out.println("데이터베이스");
          break;
        case 3: 
          System.out.println("빅데이터 분석");
          break;
        case 4: 
          System.out.println("AI");
          break;
        default:
          System.out.println("잘못 입력하였습니다.");
          break;
      }
      System.out.println("계속 입력하시겠습니까?(y/n)");
      answer = sc.next();
    } while(answer.equals("y"));
    // 📌 contentEquals
    // ontentEquals()는 String 객체와 다른 객체 (StringBuilder나 StringBuffer 등)의 내용을 비교할 수 있도록 추가적인 유연성을 제공
    // 하지만 String 객체끼리 비교할 때 equals()가 그 역할을 함
    // 따라서 String 객체끼리 비교할 때는 equals()가 contentEquals()보다 더 일반적으로 사용되고,
    // contentEquals()는 String이 아닌 다른 객체와 비교할 때 유용
    sc.close();
  }
}

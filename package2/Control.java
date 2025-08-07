package package2;

import java.util.Scanner;

public class Control {
  public static void main(String[] args) {
    // 제어문 반복문 : 프로그램의 흐름을 위해서 아래로 진행됨 -> 방향을 바꾸는 역할
    // if문
    int score = 85;
    String grade = "";
    if (score >= 90){
      if (score >= 95){
          grade = "A+";
        } else {
          grade = "A0";
        }
      } else {
        if (score >= 85){
          grade = "B+";
      } else {
          grade = "B0";
      }
    }

    // switch

    Scanner sc = new Scanner(System.in);

    System.out.print("학년 입력 : ");
    // int year = sc.nextInt();
    String year = sc.next(); // 문자열로

    switch (year) {
      case "1" :
        System.err.println("1학년");
        break;
      case "2" :
        System.err.println("2학년");
        break;
      case "3" :
        System.err.println("3학년");
        break;
      case "4" :
        System.err.println("4학년");
        break;
      default:
        System.err.println("잘못 입력했습니다");
    }
    // switch (year) {
    //   case 1 :
    //     System.err.println("1학년");
    //     break;
    //   case 2 :
    //     System.err.println("2학년");
    //     break;
    //   case 3 :
    //     System.err.println("3학년");
    //     break;
    //   case 4 :
    //     System.err.println("4학년");
    //     break;
    //   default:
    //     System.err.println("잘못 입력했습니다");
    // }

    int score1;
    char grade1;

    System.out.println("점수 입력(0~100) : ");
    score1 = sc.nextInt();

    switch (score1/10) {
      case 10:
      case 9:
        grade1 = 'A';
        break;
      case 8:
        grade1 = 'B';
        break;
      case 7:
        grade1 = 'C';
        break;
      case 6:
        grade1 = 'D';
        break;
      default:
        grade1 = 'F';
    }
    // switch (score1) {
    //   case 100:
    //   case 90:
    //     grade1 = 'A';
    //     break;
    //   case 80:
    //     grade1 = 'B';
    //     break;
    //   case 70:
    //     grade1 = 'C';
    //     break;
    //   case 60:
    //     grade1 = 'D';
    //     break;
    //   default:
    //     grade1 = 'F';
    // }

    System.err.println(grade1);
    
    sc.close();
  }
}

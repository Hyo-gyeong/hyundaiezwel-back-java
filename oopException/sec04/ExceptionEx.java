package oopException.sec04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    try {
      System.out.print("정수 1 입력 : ");
      int num1 = sc.nextInt();
      System.out.print("정수 2 입력 : ");
      int num2 = sc.nextInt();
      int rslt = num1/num2;
      System.out.println("나누기 결과 : " + rslt);
    }catch(InputMismatchException e){
      System.out.println("입력 값이 정수형이 아님");
    }catch (ArithmeticException e ){
      System.out.println("0으로 나눌 수 없습니다.");
    }catch (Exception e ){
      System.out.println("오류 발생 : " + e);
    }
    sc.close();
  }
}

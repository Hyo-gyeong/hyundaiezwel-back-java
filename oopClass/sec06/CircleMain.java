package oopClass.sec06;

import java.util.Scanner;

public class CircleMain {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Circle circle = new Circle();

    circle.setCircle(5);
    float result = circle.area(); // 또는 자동 형변환 되는 더 큰 범위의 타입이어야 함
    System.out.println("원의 넓이 : " + result);
    sc.close();
  }
}

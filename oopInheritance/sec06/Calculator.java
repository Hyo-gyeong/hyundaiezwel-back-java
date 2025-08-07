package oopInheritance.sec06;

public class Calculator {

  double areaCircle(double r){ // 접근제한 생략 - default
    System.out.println("Calculator 객체의 areaCircle() 실행");
    return 3.14159*r*r;
  }
}

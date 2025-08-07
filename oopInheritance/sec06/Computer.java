package oopInheritance.sec06;

public class Computer extends Calculator{

  @Override
  double areaCircle(double r){ // 부모가 default 접근제한을 가지고있기 때문에 동이하거나 더 범위가 넓어야 함
    System.out.println("Computer 객체의 areaCircle() 실행");
    return Math.PI*r*r; // 정밀한 계산으로 수정
  }
}

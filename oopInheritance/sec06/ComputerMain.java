package oopInheritance.sec06;

public class ComputerMain {
  public static void main(String[] args) {
    // 오버라이딩된 메서드 활용

    int r = 10;

    // super class의 메서드 호출
    Calculator calculator = new Calculator(); // 기본 생성자 생성됨
    System.out.println("원의 넓이 : "+calculator.areaCircle(r));

    // sub class의 메서드 호출
    Computer computer = new Computer();
    System.out.println("정밀한 원의 넓이 : " + computer.areaCircle(r)); // 재정의된 메서드 사용, 재정의 안되어있으면 부모 메서드 그대로
    
  }
}

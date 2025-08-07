package oopInheritance.sec04;

public class EmpMain {
  public static void main(String[] args) {
    // 서브클래스의 인스턴스(객체) 생성하면서
    // 서브클래스의 생성자에게 인수 전달
    // 슈퍼클래스가 필요한 인수도 같이 전달하고 서브 클래스의 생성자에서 부모클래스로 전달하도록 구현
    Manager manager = new Manager("4432", "이순신", "개발팀", "대리");

    // 자식클래스 인스턴스 출력
    // toString 오버라이딩 함
    System.out.println(manager);
  }
}

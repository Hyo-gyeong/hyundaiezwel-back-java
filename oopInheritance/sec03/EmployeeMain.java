package oopInheritance.sec03;

public class EmployeeMain {
  public static void main(String[] args) {
    EmployeeToString emp1 = new EmployeeToString("1234", "홍길동", "마케팅");
    EmployeeToString emp2 = new EmployeeToString("3546", "이몽룡", "영역부");

    // toString() 오버라이딩 되어있는 인스턴스 - toString호출하지 않아도 자동 호출됨
    // toString을 오버라이딩 하지 않으면 주소(?) 뜸 : oopInheritance.sec03.EmployeeToString@372f7a8d 이렇게
    System.out.println(emp1);
    System.out.println(emp2);
  }
}

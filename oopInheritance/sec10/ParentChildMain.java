package oopInheritance.sec10;

public class ParentChildMain {
  public static void main(String[] args) {
    Child child = new Child();

    // 자동 타입변환과 다형성
    // 자식에서 재정의된 것들을 Parent에서 확인할 수 있음
    // 📍변수는 선언된 타입 기준으로 고정되고
    // 📍메서드는 실제 객체 기준으로 유연하게 바뀐다.

    // 부모 클래스 타입의 참조변수 선언
    Parent p = child; // Parent 타입 객체 인스턴스 참조를 Child타입의 인스턴스 연결, 자동 타입 변환 -> sub to super
    // parent 변수는 child객체를 참조하지만 

    p.method1(); // Parent 클래스의 method사용 가능
    p.method2(); // subclass method 호출
    //p.method3(); // Child 클래스의 method 참조 불가능

  }
}

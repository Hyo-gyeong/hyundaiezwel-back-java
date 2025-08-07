package oopClass.sec11;

public class TestMain {
  public static void main(String[] args) {
    // 인스턴스 멤버 접근 방법
    // 각각의 인스턴스 멤버는 서로 다른 변수임
    Test t1 = new Test();
    t1.width = 100;
    t1.height = 200;
    t1.area();
    
    Test t2 = new Test();
    t2.width = 10;
    t2.height = 20;
    t2.area();

    // t1.height1 = 200; // static은 객체로 접근은 가능하지만 권장하지 않음.
    Test.width1 = 600; // 클래스로 접근하는 것을 권장
    Test.area1();

  }
}

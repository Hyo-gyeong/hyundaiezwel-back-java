package oopClass.sec12;

public class StaticTest {
  // 인스턴스 멤버 필드 / 메서드
  // static 메서드는 static멤버만 접근 가능
  int a;
  void f1(int x){ // 인스턴스 메서드에서 인스턴스 필드 사용 가능
    a = x;
  }
  void f2(int x){ // 인스턴스 메서드에서 static 필드 사용 가능
    b = x;
  }
  void f3(int x){ // 인스턴스 메서드에서 static 필드 사용 가능
    s3(x); // static은 한 군데서 관리되니까 가능
  }

  static int b;
  static void s1(int x){ // static 메서드는 인스턴스 멤버 사용 불가
    // a = x; // 어떤 객체의 a인지 모름
  }
  static void s2(int x){ // static 메서드는 인스턴스 메서드 호출 불가
    // f1(x); // 어떤 객체의 f1인지 모름
  }
  static void s3(int x){ // static 메소드 static 필드 사용 가능
    b = x;
  }
  static void s4(int x){ // static 메소드 static 메소드 호출 가능
    s1(x);
  }
}

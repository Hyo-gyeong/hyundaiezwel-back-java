package oopClass.sec14;

public class StaticBlock {
  // static 블록 : static 멤버만 모아놓은 영역
  // 인스턴스 필드와 메소드
  int a;
  void method() {/*... */}

  static int staticA;
  static void staticMethod() {/*... */}

  // staticl block
  static {
    int b = 1;
    // static block인에는 메소드가 올 수 없음
    // void method1(){ // Syntax error on token "void"
    //   System.out.println("sdfsdf");
    // }
    
    // static 변수, 메서드 부를 수 있음
    staticA = 10;
    staticMethod();
  }

  static { // static 필드의 선언과 초기화는 static block 이용
          // 클래스가 메서드 영역으로 로딩될 때 자동으로 실행하는 블럭
    int c = 0;
    double bc = 0.5;
  }

  { // 인스턴스 필드는 대부분 생성자 통해서 초기화 이루어지기 때문에 초기화 블럭을 사용하지 않음
    int a1 = 10;
    int b1 = 10;
  }

  Share s1 = new Share();
  static void staticMethod2(){
    // a = 2; // 인스턴스 멤버라서 불가능
    // this.a = 2; // static 메서드 안에서는 this도 사용 불가능

    // 객체를 생성하고 인스턴스로 접근하는건 가능
    // s1.showA(); // 외부에 정의하는건 여전히 인스턴스 함수여서 접근 안됨
    Share s2 = new Share(); // 내부에 만들어서 사용하는건 가능 - 모든 인스턴스에 영향을 미치는게 아님
                                                         // - 특정 인스턴스가 가진 멤버를 사용할 수 있음
    s2.showA(); // 가능!
  }
}

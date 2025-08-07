package oopClass.sec15;

public class Singleton {
  // #### 싱글톤 패턴의 클래스 구현 ####

  // 하나의 애플리케이션 내에서 객체가 하나만 생성되도록 하는 것
  // 클래스 내부에서 클래스 자신의 객체 한 번 생성하고 필요한 경우 만들어 놓은 객체 반환
  // 자기자신 클래스 타입으로 static 필드 생성 - Singleton 클래스의 객체 생성
  private static Singleton singleton = new Singleton(); // 딱 한번만 생성됨

  // 생성자를 외부에서 쓸 수 없도록 private로 메서드 접근 제한
  private Singleton(){}

  // static으로 위에서 생성한 객체 참조 변수를 반환하는 메서드 구현 - 외부에서는 받아서 사용만 할 수 있도록
  static Singleton getSingleton(){
    return singleton; // 위에서 생성한 객체의 참조 변수가 반환
  }

}

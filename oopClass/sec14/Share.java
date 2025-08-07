package oopClass.sec14;

public class Share {
  int a; // 인스턴스 필드
  static int staticA; // static 필드, 선언할 때 초기화하는게 일반적이지만 기본값은 0

  public void set(int n){ // 인스턴스 메소드
    a += n;
    staticA += n;
  }

  public int showA(){
    return a;
  }

  public static int showStaticA(){
    return staticA;
  }
}

package oopInheritance.sec05;

// super ref 사용 예제
class SuperClass {
  int x; // protected (default) : 동일 패키지 내 클래스에게 상속됨
  int y;

  public SuperClass(){
    x = 5;
    y = 50;
  }
}

class SubClass extends SuperClass{
  int x; // 인스턴스 멤버 변수
  
  public SubClass(){
    this.x = 10;
  }

  public void show(){
    System.out.println("subclass x : " + this.x);
    System.out.println("subclass x : " + x); // = this.x
    System.out.println("subclass x : " + this.x);
    System.out.println("subclass x : " + super.y);
    System.out.println("subclass x : " + y); // = super.y, super에만 있으니까
  }
}

public class SuperRefMain {
  public static void main(String[] args) {
    // SubClass 인스턴스 생성
    SubClass sc = new SubClass(); // SuperClass 생성자 자동 호출 -> 멤버필드 초기화 진행
    sc.show();
    
  }
}

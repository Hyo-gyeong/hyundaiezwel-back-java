package oopInheritance.sec02;

class A {
  public A(){
    System.out.println("기본 생성자 A");
  }

  public A(int x){
    System.out.println("매개변수 생성자 A : " + x);
  }
}

class B extends A {
  public B(){
    System.out.println("기본 생성자 B");
  }

  public B(int x){
    // 명시적으로 지정하지 않았기 때문에 A의 기본 생성자를 호출
    System.out.println("매개변수 생성자 B : " + x);
  }
}

class C extends B {
  public C(){
    System.out.println("기본 생성자 C");
  }

  public C(int x){
    super(x); // 명시적으로 생성자를 지정했기 때문에 기본생성자가 아닌 매개변수가 int 1개인 생성자 호출
              // 부모클래스 생성자는 당연히 맨 처음에 불려야 함.
    System.out.println("매개변수 생성자 C : " + x);
    // super(x); // 이 위치에서는 불릴 수 없음. 순서가 맞지 않음.
  }

  public void tmp(){
    // super(x);//일반 메서드에서는 사용 불가, 생성자 내에서만 사용 가능
  }
}

public class SuperConstTest {
  public static void main(String[] args) {
    // C클래스 인스턴스 생성
    C c = new C(); // 명시적으로 부모 클래스 생성자 호출하지 않음, 매개변수가 없는 기본 생성자가 자동 호출 됨
    
    // C클래스 인스턴스 생성 - 매개변수 있는 생성자 메소드 사용
    C c1 = new C(5);

  }
}

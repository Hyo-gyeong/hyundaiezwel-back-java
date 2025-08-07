package oopInheritance.sec01;

// Parent 클래스 상속
public class Child extends Parent { // 상속받는 클래스의 생성자를 전부 실행 후 자신의 생성자 실행
                                    // 자식에서부터 부모로 올라가며 호출되고 부모에서부터 자식순으로 실행됨
  private int c;

  public Child(){ // 이 중괄호가 열리는 시점에 Parent 생성자 호출함

  }

  public void setChild(){
    c = 20;
  }

  public void showChild(){
    // 부모클래스의 필드와 메서드 중 private 접근 제한이 아닌 멤버들은 child에서 사용 가능
    showParent();
    System.out.println("자식 클래스 c : " + this.c);
  }
}

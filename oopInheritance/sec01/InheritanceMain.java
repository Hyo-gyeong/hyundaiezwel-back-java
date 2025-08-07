package oopInheritance.sec01;

public class InheritanceMain {
  public static void main(String[] args) {
    // Parent 상속받은 Child 클래스 사용
    Child child = new Child();

    // 자신의 메소드 사용
    child.setChild();
    child.showChild();
    // child 클래스 인스턴스를 통해서 parent클래스 메소드 호출
    child.setParent(); // public
    child.showParent(); // public

    Parent p = new Parent(); // 부모클래스 인스턴스
    p.showParent();
    // p.showChild(); // 부모에서는 자식을 호출할 수 없음
  }
}

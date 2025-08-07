package oopClass.sec07;

public class ConstructorMain {
  public static void main(String[] args) {
    // 어떠한 생성자도 만들지 않으면 디폴트 생성자가 생성되는것.
    Constructor cst = new Constructor(); // 클래스 내에 명시적 생성자가 있음
    cst.show();
    Constructor cst1 = new Constructor(1);
    cst1.show();
    Constructor cst2 = new Constructor(1, 2);
    cst2.show();

  }
}

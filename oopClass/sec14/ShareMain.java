package oopClass.sec14;

public class ShareMain {
  public static void main(String[] args) {
    Share s1;
    Share s2;

    s1 = new Share();
    s1.set(5);

    System.out.println("s1의 a " + s1.showA());
    System.out.println("staticA : " + s1.showStaticA());

    s2 = new Share();
    s2.set(7);

    System.out.println("s2의 a " + s2.showA());
    System.out.println("staticA : " + s2.showStaticA());
    System.out.println("staticA : " + Share.showStaticA());
    System.out.println("staticA : " + s1.showStaticA()); // 동일하게 변경됨
  }
}

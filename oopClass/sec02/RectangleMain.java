package oopClass.sec02;

public class RectangleMain {
  public static void main(String[] args) {
    Rectangle r = new Rectangle();
    r.input();
    r.area();

    Rectangle r1 = new Rectangle();
    r1.width = 10;
    r1.height = 20;
    r1.area();
  }
}

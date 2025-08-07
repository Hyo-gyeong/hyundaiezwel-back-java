package oopInheritance.sec13;

public class LineMain {
  public static void main(String[] args) {
    Line line = new Line();
    line.draw();

    Circle circle = new Circle();
    circle.draw();

    Rect rect = new Rect();
    rect.draw();

    // 추상클래스는 객체생성 불가능
    // DrawingObject dObject = new DrawingObject();
  }
}

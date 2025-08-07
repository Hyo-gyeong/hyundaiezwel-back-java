package oopInheritance.sec13;

public abstract class DrawingObject {
  // 추상 클래스 : 추상 메서드를 포함하는 경우에 사용
  // 멤버필드/ 멤버 메서드/ 생성자 포함 가능
  public String penColor;

  // 추상 메서드 - subclass에서 기능 정의해서 사용
  // 메서드명, 접근제한, 리턴타입만 지정해줌
  public abstract void draw();
}

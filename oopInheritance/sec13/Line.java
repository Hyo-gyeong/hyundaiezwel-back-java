package oopInheritance.sec13;

public class Line extends DrawingObject {

  public Line(){
    penColor = "red"; // 내부에는 정의되어있지 않은 필드지만 부모로부터 상속받은 객체에 있는 필드이기 때문에 접근 가능
  }

  @Override
  public void draw() {
    // 추상 메서드 구현
    System.out.println(penColor+"색상으로 선 그리기");
  }
  
}

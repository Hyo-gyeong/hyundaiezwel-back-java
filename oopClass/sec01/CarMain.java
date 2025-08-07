package oopClass.sec01;

public class CarMain {
  public static void main(String[] args) {
    // 사용자 정의 클래스 Car를 사용
    // 1. Car 클래스 객체 생성
    // 2. 새성된 객체를 통해서 멤버변수나 멤버 메소드 사용(사용은 접근 제한에 따라 다름)
    // 동일 패키지 내에 있기 때문에 import없이 사용 가능
    Car c = new Car();
    
    // 객체를 통해서 멤버 변수 또는 멤버 메소드 사용 불가능 - private
    // c.carNo = "123더1234"

    // 객체 통해서 public 메소드 호출
    c.setCarInfo("11가1111", "k7", "기아"); // c 참조 변수가 참조하고 있는 멤버 변수에 값이 저장됨
    c.showCarInfo(); // c 참조 변수가 참조하고 있는 멤버 변수값 출력 

    Car b = new Car();
    b.setCarInfo("22나2222", "그렌저", "현대");
    b.showCarInfo();
  }
}

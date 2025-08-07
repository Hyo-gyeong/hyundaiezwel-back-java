package oopClass.sec08;

public class CarMain {
  public static void main(String[] args) {
    // Car c = new Car(); // 명시적으로 생성하고 기본 생성자 안만들면 내부적으로 자동으로 만들지 않아서 기본 생성자 못씀
    Car c = new Car("11가1111", "k7", "기아");

    // 객체 통해서 public 메소드 호출
    c.setCarInfo("11가1111", "k7", "기아", 2025, 1500); // c 참조 변수가 참조하고 있는 멤버 변수에 값이 저장됨
    c.showCarInfo(); 

    Car b = new Car();
    b.setCarInfo("22나2222", "그렌저", "현대", 2023, 2000);
    b.showCarInfo();
  }
}

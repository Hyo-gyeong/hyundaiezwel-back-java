package InterfacePackage.sec05;

public class DriverMain {
  public static void main(String[] args) {
    Driver driver = new Driver();
    Bus bus = new Bus();
    Taxi taxi = new Taxi();

    // 다형성의 일환으로 superclass를 extends하는 subclass를 전달할 수 있음 (자동 타입변환)
    // 직접 대입 외에도 매개변수 전달에서도 자동 타입변환 발생 가능
    // Overriding된 subclass의 run메소드가 호출됨
    // 인터페이스가 어떻게 정의되어있는지만 알면 개발자는 원하는 매개변수를 넣어서 다양하게 쓸 수 있음
    driver.driver(bus);
    driver.driver(taxi);
  }
}

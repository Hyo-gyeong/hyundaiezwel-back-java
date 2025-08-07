package InterfacePackage.sec05;

public class Driver {
  // 매개변수로 Vehicle을 받는 메소드
  // Vehicle는 Bus와 Taxi에 상속되었고 run메소드는 재정의됨
  public void driver(Vehicle v){
    v.run();
  }
}

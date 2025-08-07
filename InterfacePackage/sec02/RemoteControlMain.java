package InterfacePackage.sec02;

public class RemoteControlMain {
  public static void main(String[] args) {
    RemoteControl rc = null; //초기화

    rc = new Television(); // Television 객체 활용
    rc.turnOn();
    rc.turnOff();
    rc.setVolume(5);
    rc.setMute(true); // 디폴트 메서드지만 재정의 되었음(Television에서 재정의된 메소드가 호출)
    rc.setMute(false);

    System.out.println("---------------------------");

    rc = new Audio(); // Audio 객체 활용
    rc.turnOn();
    rc.turnOff();
    rc.setVolume(50);
    rc.setMute(true); // 재정의 하지 않았으므로 interface내에 정의되어있는 기본 메서드가 호출됨

    // 정적 메서드 사용
    RemoteControl.changeBattery();
    //rc.showRemote(); // 인터페이스의 static 메소드여도 인터페이스 참조변수를 통해서 접근 불가능
    RemoteControl.showRemote(); // 반드시 인터페이스를 통해서만 접근 해야함

  }
}

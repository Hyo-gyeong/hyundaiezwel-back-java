package InterfacePackage.sec03;

public class SmartRemoteControlMain{
  public static void main(String[] args) {
    // 2개 인터페이스의 기능 구현한 글래스 통해서 기능 확인
    SmartTelevision stv = new SmartTelevision();
    stv.turnOn();
    stv.setVolume(4);

    // interface 활용
    RemoteControl rc = new SmartTelevision();
    rc.turnOff();
    ISearchable se = new SmartTelevision(); 
    se.search("www.daum.net");
    // se.turnOff(); // 타입 변환이 있어도 ISearchable에 아예 정의가 안되어있기 때문에 사용 불가
  }
}

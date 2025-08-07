package InterfacePackage.sec01;

public interface ISmartPhone {
  // String name = "a"; 이렇게 쓰니까 일반 멤버같지만
  // 인터페이스 내에 있기 때문에 무조건 알아서 상수처리됨(static final이런거 없어도)
  // 따라서 반드시 초기화되어야 함
  static String name = "smartphone";
  
  // static으로 초기화
  // static int a;
  // static {
  //   a = 1;
  // }

  // 구현되는 클래스의 메소드 설계도 역할
  // 객체가 갖고있을 메서드를 설명하는 부분 (접근제한, 반환타입, 메소드명, 매개변수 지정)
  public void sendCall(); // 상속받는 객체가 '반드시' 구현해야함
  public void receiveCall();
  public void sendSMS();
  public void receiveSMS();

}

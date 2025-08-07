package InterfacePackage.sec01;

public class SamsungPhone implements ISmartPhone { // interface에 있는 모든 메소드를 재정의해야함
  // 클래스이므로 클래스가 갖는 필드, 메서드 추가 가능
  String name;

  public SamsungPhone() {
    this.name = "삼성폰";
  }

  @Override
  public void sendCall() {
    System.out.println(name + "으로 전화를 겁니다");
  }

  @Override
  public void receiveCall() {
    System.out.println(name + "으로 전화를 받습니다");
  }

  @Override
  public void sendSMS() {
    System.out.println(name + "으로 문자를 보냅니다");
  }

  @Override
  public void receiveSMS() {
    System.out.println(name + "으로 문자를 받습니다");
  }

  public void callCenter() {
    System.out.println("삼성 콜센터로 전화를 겁니다.");
  }

}

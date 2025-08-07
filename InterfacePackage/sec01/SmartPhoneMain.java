package InterfacePackage.sec01;

public class SmartPhoneMain {
  public static void main(String[] args) {
    // interface 사용
    // 객체에 종속되는 인스턴스 사용
    SamsungPhone sphone = new SamsungPhone();
    sphone.sendCall();

    // interface 참조변수 사용
    ISmartPhone isphone = new SamsungPhone(); // 구현 클래스 객체 참조 - 인터페이스를 객체처럼 사용할 수 있게됨
    isphone.sendCall();
    // isphone.name; // 사용 불가능. name은 SamsungPhone에 있는 필드이므로.

    // isphone.callCenter();
    // isphone = new IPhone();

    // interface 참조변수를 통해서 IPhone 객체 사용
    // main <-> interface <-> 객체들
    ISmartPhone iip = new IPhone();
    iip.receiveSMS();
  }
}

package InterfacePackage.sec04;

public class ImplementationC implements InterfaceC {
  // interface가 싱속받은 InterfaceA, InterfaceB에 대한 메소드까지 전부 구현

  @Override
  public void methodA() {
    System.out.println("ImplementaionC에서 methodA 실행");
  }
  
  @Override
  public void methodB() {
    System.out.println("ImplementaionC에서 methodB 실행");
    
  }
  
  @Override
  public void methodC() {
    System.out.println("ImplementaionC에서 methodC 실행");

  }
  
}

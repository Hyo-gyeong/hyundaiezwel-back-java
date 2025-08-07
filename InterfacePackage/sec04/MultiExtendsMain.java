package InterfacePackage.sec04;

public class MultiExtendsMain {
  public static void main(String[] args) {
    // interface 활용
    ImplementationC c = new ImplementationC(); // 구현클래스 객체 생성
    
    // InterfaceA
    InterfaceA ia = c; // c는 더 많은 내용을 구현하고 있지만 A가 부모이기 때문에
                        // c가 InterfaceA타입으로 자동 형변환이 발생
    ia.methodA(); // InterfaceA 타입이기 때문에 methodA만 사용 가능

    InterfaceB ib = c; // 자동 형변환이 일어나면서 InterfaceB로 형변환됨
    // ib.methodA(); // 불가능
    ib.methodB(); // 가능

    // InterfaceC
    InterfaceC ic = c;
    // InterfaceC가 InterfaceA, InterfaceB를 모두 상속받아서 구현하고 있기 때문에
    // 정의, 재정의한 모든 메서드 사용 가능
    ic.methodA();
    ic.methodB();
    ic.methodC();
  }
}

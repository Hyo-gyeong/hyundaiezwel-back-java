package oopInheritance.sec12;

public class CastMain {
  public static void main(String[] args) {
    // 강제 타입 변환
    // 부모타입으로 변환되어 있는 상태에서만 원래대로 강제 타입 변환 가능
    Animal ap = null;

    ap = new Dog(); // 자동 타입 변환
    ap.show(); // 재정의 해놨으므로 Dog클래스 메서드 호출됨
    ap.sound();
    
    ap.animalMethod(); // Animal 객체가 가지고있는 메서드 (재정의x)
    // ap.dogMethod(); // 자식 클래스만 가지고있는 메서드는 사용 불가

    // Dog 클래스 참조변수 선언
    // ap타입은 Animal이지만 참조하고 있는 객체는 Dog
    // Dog d = ap;  //어차피 둘 다 Dog를 참조하니까 연결해주면 안될까 싶지만                  
                    // Type mismatch: cannot convert from Animal to Dog 에러남
                    // ap는 Dog -> Animal로 자동형변환이 적용되어 Dog객체를 참조중이므로
    // 강제 형변환 필요
    Dog d = (Dog) ap;
    d.sound();
    d.dogMethod(); // Dog타입으로 강제 형변환이 되어있기 때문에 dogMethod사용 가능

    // instanceof : 객체가 참조하고 있는 인스턴스의 타입 검사를 진행
    // 객체 instanceof type -> 참조타입이면 true반환
    // 부모타입 객체가 모두 자식 타입으로 강제 형변환 가능하지 않음. 자식 타입에 근거한 객체여야 함
    Animal aa = new Animal();
    // Dog dd = (Dog) aa; // 컴파일은 되지만 (문법 오류 없음) 런타임에서 오류 발생(근거하는 참조 타입 검사) : java.lang.ClassCastException
    // 따라서 instanceof로 검사를 해야함
    if (aa instanceof Dog){
      Dog dog = (Dog) aa;
      System.err.println("Dog 타입으로 변환 가능");
    } else {
      System.err.println("Dog 타입으로 변환 불가");
    }
  }
}

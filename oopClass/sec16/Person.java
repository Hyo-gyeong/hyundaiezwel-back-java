package oopClass.sec16;

public class Person {
  // final : 초기화 되면 수정할 수 없는 필드
  // 객체마다 다를 수 있어서 클래스 전체에서 "공통적으로" 사용되지는 않음
  // + 불변 + 공통 => static final로 선언해야함. 즉 클래스 레벨에서 통용되며 모든 인스턴스가 같은 값을 공유하는 필드라는 뜻
  /*
   * final : '인스턴스 내' 불변 필드, 클래스 레벨에서 공유되지 않고 객체마다 다름, 변경 불가능
   * static : 모든 객체가 공유, 클래스 레벨에서 공유됨, 변경 가능
   * static final : 모든 객체가 공유하는 상수, 클래스 레벨에서 공유됨, 변경 불가능
   */
  final String nation = "Korea";
  // final int a; // ## 어디서도 초기화를 안해줘서 에러남
  String name;
  final String ssn; // 초기값은 인스턴스가 생성될 때 부여 -> 명시적 생성자에서 부여

  public Person(String ssn, String name){ // ## final은 선언할때나 생성자에서 반드시 초기화가 되어야함, 외부에서 초기화 불가
    this.ssn = ssn;
    this.name = name;
  }
}

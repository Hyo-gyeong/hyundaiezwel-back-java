package genericCollection.sec13;

import java.lang.String;

public class Member2 {
  public String name;
  public int age;

  public Member2(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // 객체 인스턴스에서 저장된 필드 값이 완전히 같으면 객체 참조 주소가 달라도 같은 객체로 보고 set에 중복저장되지 않도록 구현
  // hashCode() 먼저 실행 후 동일한 해시값인 경우에만 equals() 실행
  // equals() == true 이면 반드시 hashCode()도 같아야 함, 반대로 hashCode()가 같다고 해서 equals()도
  // 반드시 true일 필요는 없음

  // 두 번 비교하는 이유? => 성능때문에
  // hashCode()는 숫자 기반으로 빠르게 비교 가능하지만 equals()는 비교 로직이 더 복잡하고 느릴 수 있으므로
  // 또한 동일한 해시코드를 가진 다른 객체가 존재하는 충돌(Hash Collision)이 발생할 수 있기 때문에
  // hashCode로 1차 필터링을 한 후 equals로 2차 확인

  // 1. Object로부터 상속받은 hashCode() 메서드 재정의
  // hashCode는 객체의 참조값을 반환하는데 필드값이 동일하면 같은 값을 반환하도록 구현
  // Object의 기본 동작 : JVM이 메모리 주소 기반 생성, 재정의할 때 : 필드값 기반으로 직접 계산
  @Override
  public int hashCode() {
    // name.hashCode() : 문자열이 같으면 hashCode값이 같음, int형은 hashCode() 메서드가 없음
    System.out.println(name.hashCode() + age);
    return name.hashCode() + age;
  }

  // 2. Object로부터 상속받은 equals() 메서드 재정의 -> 어떤 경우에 같은 값으로 볼건지
  // Object의 기본 동작 : 참조값(주소) 비교 (==), 재정의할 때 : 내부 필드값 비교
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Member2) {
      Member2 member2 = (Member2) obj;
      return member2.name.equals(this.name) && (member2.age == this.age);
    } else { // Member2에 기인하지 않는 객체는 비교할 것도 없음
      return false;
    }
  }
}

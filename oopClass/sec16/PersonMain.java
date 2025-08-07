package oopClass.sec16;

public class PersonMain {
  public static void main(String[] args) {
    // final 필드 사용
    Person p1 = new Person("123123-123123", "계백");

    System.out.println(p1.nation); // 읽기 전용
    System.out.println(p1.name); // 일반필드
    System.out.println(p1.ssn); // 읽기 전용

    // p1.nation = "USA"; // 초기화된 final이므로 에러남
    p1.name = "을지문덕";
    // p1.ssn = "123123-123123123123"; // 초기화된 final이므로 수정 불가
  }
}

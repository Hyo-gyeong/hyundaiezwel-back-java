package oopApi.sec04;

public class AutoBoxingUnBoxing {
  public static void main(String[] args) {
    // 포장객체의 기본 타입에 대한 자동 박싱/언박싱
    // 자동 박싱
    Integer obj = 100; // 100기본값이 obj가 참조하게된 객체의 필드로 저장(객체 생성)
    System.out.println(obj.intValue()); // obj안에 있는 value값을 가져와서 확인

    // 자동 언박싱
    int value = obj; // 객체참조 변수를 기본 변수에 대입
    // 기본값과 레퍼참조 객체의 연산시 자동 언박싱
    int result = obj + 200; // obj 객체와 기본값의 연산
    System.out.println(result);

    // 레퍼 클래스는 static 메서드로 문자열을 기본 타입값으로 변환시키는 기능을 갖음
    // parseXXX()
    Short.parseShort("100"); // String -> short 타입의 기본값 100으로 변환
    Double.parseDouble("3.5"); // String -> double 타입의 기본 리터럴 3.5로 변환
    Boolean.parseBoolean("true"); // boolean타입의 리터럴 true반환

    // 레퍼 클래스의 내부 값 비교 : == != 연산자 사용 불가, 언박싱에서 비교하거나 equals() 사용
  }
}

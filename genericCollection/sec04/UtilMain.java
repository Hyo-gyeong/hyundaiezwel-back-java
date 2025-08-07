package genericCollection.sec04;

public class UtilMain {
  public static void main(String[] args) {
    // Util 클래스 static 메서드 사용 예시
    // Util 클래스 boxing 메서드 제네릭, static Box 타입 반환
    // 메서드 호출 시 타입을 구체화
    Box<Integer> box1 = Util.<Integer>boxing(100); // 반환값 box 객체
    int intValue = box1.get();

    Box<String> box2 = Util.<String>boxing("홍길동"); // 타입 파라미터가 T고 매개변수는 T 타입을 전달해야 함
    Box<String> box3 = Util.boxing("홍길동"); //  매개변수가 타입을 유추 가능하니까 파라미터 구체화 생략 가능
    String strValue = box3.get();

    System.out.println(intValue);
    System.out.println(strValue);

  }
}

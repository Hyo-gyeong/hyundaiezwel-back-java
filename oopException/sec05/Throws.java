package oopException.sec05;

public class Throws {
  public static void main(String[] args) {
    // 메소드에서 호출한 곳으로 예외 떠넘기기 (throws 구문)
    // findClass(); // 메소드에 throws 구문이 있는 경우는 try~catch 구문을 반드시 사용해야 함(단독 호출 에러 발생)
    try {
      findClass(); // 클래스 호출하면 예외를 다시 떠넘기거나 처리를 해줘야 함
    } catch (ClassNotFoundException e){
      System.out.println("메소드에서 throws로 떠넘긴 예외는 메소드 호출 시 반드시 처리해야 함");
    }
  }

  public static void findClass() throws ClassNotFoundException { // 예외 떠넘기기
    Class c = Class.forName("java.lang.String2");
  }
}

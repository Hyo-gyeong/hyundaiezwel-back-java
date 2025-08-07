package oopException.sec02;

public class TryCatchMain {
  public static void main(String[] args) {
    String data1 = "3";
    String data2 = "a3";

    // 라이브러리 클래스 존재 확인시 발생하는 오류
    try {
      Class c = Class.forName("java.lang.String2");
    } catch (ClassNotFoundException e){
      System.out.println("class not found");
    }
    // 오류 발생하더라도 catch에서 정상실행 됐기 때문에 try~catch 블록 아래 코드는 실행됨

    // 문자열을 정수로 변환 - 문법적 오류 없음. 단, 문자열에 변환 불가능한 문자가 포함되어 있으면 오류가 발생할 수 있음
    try {
      int value1 = Integer.parseInt(data1); // try 블록 안에서만 사용 가능
      int value2 = Integer.parseInt(data2); // try 블록 안에서만 사용 가능
      int result = value1 + value2; // try 블록 안에서만 사용 가능
    } catch (NumberFormatException e) {
      System.out.println("숫자로 변환할 수 없습니다.");
    } finally {
      System.out.println("다시 실행 하세요.");
    }
    // int result = value1 + value2; // 사용 불가
  }
}

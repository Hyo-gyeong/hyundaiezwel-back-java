package oopException.sec06;

// 컴파일러가 처리하는 예외를 클래스로 생성 : extends Exception
public class BalanceInsufficientException extends Exception{
  // 예외 클래스여도 사용자정의 클래스이므로 필드, 생성자, 메소드 포함 가능하지만 보통은 생성자만 포함
  // 매개변수 없는 기본 생성자
  // 문자열 매개변수가 있는 생성자

  public BalanceInsufficientException() {} // 기본 생성자

  public BalanceInsufficientException(String message) {
    // Exception 클래스에는 이미 message를 저장하고 꺼낼 수 있는 기능이 있음
    // super(message)는 Exception 내부의 메시지 필드에 값을 저장해주는 것
    super(message);
  }
}

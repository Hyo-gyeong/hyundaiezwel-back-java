package oopException.sec06;

public class AccountMain {
  public static void main(String[] args) {
    // 예외를 포함하고 있는 클래스 메서드 사용
    Account account = new Account();
    // 예금
    account.deposit(10000);
    System.out.println("예금액 : " + account.getBalance());

    // 출금
    try{
      account.withdraw(30000); // 메서드 구현에 예외를 포함하고 있는 메서드로 try-catch 없으면 호출 불가능
    } catch (BalanceInsufficientException e){
      // 예외 발생시킬 때 생성자로 전달된 문자열이 super()호출되면서 전달됨
      String message = e.getMessage(); // Exception 클래스에 정의된 메서드로 super(message)이렇게 준 문자열을 가져옴
      System.out.println(message);
      System.out.println();
      System.out.println("예외 추적 내용 출력");
      e.printStackTrace(); // 예외 발생된 경로 출력
    }
  }
}

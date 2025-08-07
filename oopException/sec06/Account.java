package oopException.sec06;

public class Account {
  private long balance;

  public Account(){}

  public long getBalance(){
    return this.balance;
  }

  public void deposit(int money){
    balance += money;
  }

  // 예외 발생 코드를 가지고 있는 메서드
  // 호출한 곳에서 예외를 처리하도록 (throws)
  /*
   * throws, throw 함께 사용 또는 throws만 사용 (예외를 던질 수도 있다고 선언만 하는 것은 가능, 이땐 예외처리 아예 안됨)
   * BalanceInsufficientException은 Exception을 상속한 체크 예외 (checked exception)
   * 체크 예외는 반드시 throws로 선언하거나 try-catch로 처리해야 함
   * 그런데 throws 선언 없이 throw만 있으면..
   * "예외를 던질 가능성이 있는데, 호출한 쪽에 알려주지 않았네?" → 컴파일 에러 발생
   */
  public void withdraw(int money) throws BalanceInsufficientException{ // 예외가 발생할 "수 있음"을 "선언"
    if (balance < money){ // 잔고부족시
      throw new BalanceInsufficientException("잔고 부족 : " + (money - balance) + " 부족함"); // "실제로" 예외를 "발생"
    }
    balance -= money; // 음수가 발생하면 안됨
  }
}

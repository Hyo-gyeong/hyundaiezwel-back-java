package exception;

public class InputNumberException extends Exception{

  public InputNumberException(String msg){
    super(msg);
  }
  
  public static void validateNumber(String input) throws InputNumberException {
    try{
      // 숫자라면 정수인지 아닌지 확인
      double tempNum = Double.parseDouble(input);
      int validIntNum = (int) tempNum;
      if (tempNum != validIntNum){
        throw new InputNumberException( "정수형 숫자를 입력하세요.");
      }
      
    }catch (NumberFormatException e){ // 문자인지 숫자인지 확인
      throw new InputNumberException( "문자가 아닌 숫자형을 입력하세요.");
    } 
  }

  
  public static void validateGuessRange(String input) throws InputNumberException{
    int validIntNum = Integer.parseInt(input);
    if (validIntNum < 1 || validIntNum > 10){
      throw new InputNumberException("1~10 사이의 숫자를 입력하세요.");
    }
  }
}
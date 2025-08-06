package game_project.exception;

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

  public static void validateChoiceRange(String input) throws InputNumberException{
    int validIntNum = Integer.parseInt(input);
    // 1,2,3,4중에 하나인지 확인
    if (validIntNum < 1 || validIntNum > 4){
      throw new InputNumberException( "1,2,3,4 중 하나의 숫자를 입력하세요.");
    }
  }

  public static void validateRSPrange(String input) throws InputNumberException{
    int validIntNum = Integer.parseInt(input);
    // 1,2,3중에 하나인지 확인
    if (validIntNum < 1 || validIntNum > 3){
      throw new InputNumberException( "1,2,3 중 하나의 숫자를 입력하세요.");
    }
  }
  
  public static void validateGuessRange(String input) throws InputNumberException{
    int validIntNum = Integer.parseInt(input);
    if (validIntNum < 1 || validIntNum > 10){
      throw new InputNumberException("1~10 사이의 숫자를 입력하세요.");
    }
  }
}
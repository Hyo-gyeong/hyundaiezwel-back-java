package game_project.validator;

import game_project.exception.ChoiceException;
import game_project.exception.GuessException;

// ## validator에서는 오직 간단한 검증만 수행 ##
public class GameValidator {

  public static void validateChoice(String input) throws ChoiceException{
    if (!input.equals("y") && !input.equals("n")){
      throw new ChoiceException("y 또는 n을 입력해주세요.");
    }
  }

  public static void validateNumber(String input) throws GuessException {
    try{
      // 숫자라면 정수인지 아닌지 확인
      double tempNum = Double.parseDouble(input);
      int validIntNum = (int) tempNum;
      if (tempNum != validIntNum){
        throw new GuessException( "정수형 숫자를 입력하세요.");
      }
      // 1,2,3중에 하나인지 확인
      if (validIntNum < 1 || validIntNum > 3){
        throw new GuessException( "1,2,3 중 하나의 숫자를 입력하세요.");
      }
    }catch (NumberFormatException e){ // 문자인지 숫자인지 확인
      throw new GuessException( "숫자형을 입력하세요.");
    } 
  }
  
}

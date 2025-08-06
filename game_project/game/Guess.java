package game_project.game;

import game_project.exception.InputNumberException;
import game_project.interfaces.game.GuessInterface;
import game_project.main.AppStart;
import game_project.print.GuessPrint;

public class Guess implements GuessInterface{
  // 1-10 사이의 임의의 수를 정답으로 설정
  
  @Override
  public void gameStart(){
    // 숫자를 맞출 때까지 진행
    // 초기 숫자 입력 메시지 출력
    GuessPrint.guessMessage();
    while (true) {
      try {
        String input = AppStart.sc.next();
        // 입력 값 예외 처리 - 숫자 여부 확인
        InputNumberException.validateNumber(input);
        // 입력 값 예외 처리 - 범위 확인
        InputNumberException.validateGuessRange(input);
        // 퀴즈 결과 출력
        // 퀴즈를 맞추면
        if (Integer.parseInt(input) == number){
          // 정답 알려주고
          GuessPrint.correctMessage(number);
          // 게임 종료
          break;
        // 틀리면
        } else {
          // 틀렸다는 메시지 출력 후 while문 다시 수행
          GuessPrint.wrongMessage();
        }
      } catch (InputNumberException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}

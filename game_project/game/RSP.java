package game_project.game;

import game_project.main.AppStart;
import game_project.exception.ChoiceException;
import game_project.exception.InputNumberException;
import game_project.interfaces.game.RSPInterface;
import game_project.print.GaBaBoPrint;
import game_project.validator.GameValidator;

public class RSP implements RSPInterface{
  @Override
  public void gameStart(){
    A :
    while (true) {
      try {
        // 맨 처음 & y또는 Y를 입력하면 가위바위보를 입력 메시지 띄우기 
        GaBaBoPrint.inputNumMessage();
        // 가위바위보 입력받기
        String rspInput = AppStart.sc.next();
        // 입력 값 예외 처리 - 숫자 여부 확인
        InputNumberException.validateNumber(rspInput);
        // 입력 값 예외 처리 - 범위 확인
        InputNumberException.validateRSPrange(rspInput);
        // 가위바위보 결과 출력
        result(Integer.parseInt(rspInput));
        B :
        while(true){
          // 게임을 이어갈지 묻기
          GaBaBoPrint.askContinueMessage();
          // 입력값을 받아서 소문자로 변환
          String ans = AppStart.sc.next().toLowerCase();
          int rslt = ifContinue(ans);
          if(rslt == -1){ // 게임 중단
            // 최상위 whlie문 밖으로 나가기
            break A;
          } else if (rslt == 1){ // 게임 계속
            // 게임 진행 여부 묻는 while문만 나가기
            break B;
          }
        }
      } catch (InputNumberException e) {
        // 숫자 입력값 예외 처리 문자열 출력
        System.out.println(e.getMessage());
      }
    }
  }

  @Override
  public int ifContinue(String ans){
    try{
      // 입력값 예외 처리
      GameValidator.validateChoice(ans);
      // n또는 N을 입력하면 가위바위보 게임 중단
      if (ans.equals("n")) {
        return -1;
      // y또는 Y를 입력하면 게임 계속하기
      } else if (ans.equals("y")) {
        return 1;
      }
    // 입력값이 잘못되면 input 다시 받기
    } catch (ChoiceException e){
      // y/n 입력값 예외 처리 문자열 출력
      System.out.println(e.getMessage());
      return 0;
    }
    // 정확한 입력이 아닌 경우 전부 입력값이 잘못된 것으로 처리
    return 0;
  }

  @Override
  public void result(int input) {
    // 가위바위보 배열 생성
    String[] rsp = { "가위", "바위", "보" };
    // 가위바위보 배열에 맞게 입력값을 인덱스로 처리
    int myRsp = input - 1;
    // 0-2사이 난수 발생
    int computerRsp = (int) (Math.random() * 3);
    // 비김
    if (computerRsp == myRsp) {
      GaBaBoPrint.sameMessage(rsp[myRsp], rsp[computerRsp]);
    // 사용자가 이김
    } else if (computerRsp < myRsp || (computerRsp == 2 && myRsp == 0)) { 
      GaBaBoPrint.winMessage(rsp[myRsp], rsp[computerRsp]);
    // 컴퓨터가 이김
    } else { 
      GaBaBoPrint.loseMessage(rsp[myRsp], rsp[computerRsp]);
    }
  }
}

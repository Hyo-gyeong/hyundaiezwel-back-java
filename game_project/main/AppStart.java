package game_project.main;

import java.util.Scanner;

import game_project.print.AppPrint;
import game_project.print.GaBaBoPrint;
import game_project.service.user.UserAccountService;
import game_project.user.UserDAO;
import game_project.user.UserDTO;
import game_project.game.RSP;
import game_project.exception.InputNumberException;
import game_project.game.Guess;
import game_project.info.AppInfo;

public class AppStart {
  // Scanner 자원은 한 번만 생성해서 사용
  public static final Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    RSP rsp = new RSP();
    Guess guess = new Guess();
    UserAccountService accountService = new UserAccountService();

    System.out.println("실행할 번호를 입력하세요.\n1. 회원가입 2.로그인");
    // 환영 메시지 출력
    AppPrint.welcomeMessage();
    while (true){
      try {
        // 메뉴 목록 출력
        AppPrint.menuMessage();
        // 메뉴 입력문 출력
        AppPrint.inputMenuMessage();
        // 입력값을 문자열로 받고 예외처리
        String input = sc.next();
        InputNumberException.validateNumber(input);
        InputNumberException.validateChoiceRange(input);
        // 예외처리 후 1-4번 각각에 맞는 함수 실행
        int inputNum = Integer.parseInt(input);
        if (inputNum == 1){ // 애플리케이션 정보 출력
          AppInfo.printInfo();
        } else if (inputNum == 2){ // 가위바위보 게임
          GaBaBoPrint.startMessage();
          rsp.gameStart();
        } else if (inputNum == 3){ // 랜덤숫자 맞추기 게임
          guess.gameStart();
        } else if (inputNum == 4){ // 로그인
          AppPrint.inputIdMessage();
          String id = sc.next();
          AppPrint.inputPwMessage();
          String pw = sc.next();
          accountService.userLogin(id, pw);
        } else if (inputNum == 5){ // 회원가입
          AppPrint.inputIdMessage();
          String id = sc.next();
          AppPrint.inputPwMessage();
          String pw = sc.next();
          AppPrint.inputNameMessage();
          String name = sc.next();
          accountService.signup(new UserDTO(id, name, pw));
        } else if (inputNum == 6){ // 종료
          AppPrint.endGameMessage();
          break;
        }
      } catch (InputNumberException e){
        System.out.println(e.getMessage());
      }
    }
    sc.close();
  }
}

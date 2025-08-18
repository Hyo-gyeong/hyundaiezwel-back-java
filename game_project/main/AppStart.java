package main;

import java.util.Scanner;

import controller.user.AccountController;
import print.AppPrint;
import print.GaBaBoPrint;
import user.UserDTO;
import exception.InputNumberException;
import game.Guess;
import game.RSP;
import info.AppInfo;

public class AppStart {
  // Scanner 자원은 한 번만 생성해서 사용
  public static final Scanner sc = new Scanner(System.in);
  public static String loginUser = "";
  public static void main(String[] args)  {
    RSP rsp = new RSP();
    Guess guess = new Guess();
    AccountController accountController = new AccountController();

    // 환영 메시지 출력
    AppPrint.welcomeMessage();
    while (true){
      try {
        // 메뉴 목록 출력
        AppPrint.menuMessage(loginUser);
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
        } else if (inputNum == 4){
          if (loginUser.equals("")){ // 로그인
            AppPrint.inputIdMessage();
            String id = sc.next();
            AppPrint.inputPwMessage();
            String pw = sc.next();
            String rslt = accountController.login(id, pw);
            if (!rslt.equals("")){
              loginUser = rslt;
            }
          } else { // 로그아웃
            boolean ifSuccess = accountController.logout(loginUser);
            if (ifSuccess){
              loginUser = "";
            }
          }
        } else if (inputNum == 5){ 
          if (loginUser.equals("")){ // 회원 가입
            AppPrint.inputIdMessage();
            String id = sc.next();
            AppPrint.inputPwMessage();
            String pw = sc.next();
            AppPrint.inputNameMessage();
            String name = sc.next();
            accountController.signup(new UserDTO(id, name, pw));
          } else { // 회원 탈퇴
            boolean ifSuccess = accountController.unregister(loginUser);
            if (ifSuccess){
              loginUser = "";
            }
          }
        } else if (inputNum == 6){ // 종료
          AppPrint.endGameMessage();
          break;
        }
      } catch (InputNumberException e){
        System.out.println(e.getMessage());
      } catch (Exception e){
        e.printStackTrace();
      }
    }
    sc.close();
  }
}

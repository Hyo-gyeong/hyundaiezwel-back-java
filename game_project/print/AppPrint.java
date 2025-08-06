package game_project.print;

public class AppPrint {
  private static String str;
  public static void welcomeMessage(){
    str = "****************************************\n"+
          "  ★★게임에 오신 것을 환영합니다^^  \n";
    System.out.println(str);
  }
  
  public static void menuMessage(){
    str = "****************************************\n"+
          "                  메뉴                  \n"+
          "----------------------------------------\n"+
          "1. 애플리케이션 정보\n"+
          "2. 가위바위보 게임\n"+
          "3. 숫자 알아맞히기 게임\n"+
          "4. 로그인\n"+
          "5. 회원가입\n"+
          "6. 종료\n"+
          "----------------------------------------\n";
    System.out.println(str);

  }
  
  public static void endGameMessage(){
    str = "****************************************\n"+
          "            게임을 종료합니다!            \n"+
          "****************************************\n";
    System.out.println(str);
  }
  
  public static void inputErrorMessage(){
    str = "잘못된 입력입니다.";
    System.out.println(str);
  }
  
  public static void inputMenuMessage(){
    str = "메뉴 번호 입력 : ";
    System.out.print(str);
  }

  public static void numberGameMessage(){
    str = "****************************************\n"+
          "          숫자 알아맞히기 게임            \n"+
          "----------------------------------------\n";
    System.out.println(str);
  }
}

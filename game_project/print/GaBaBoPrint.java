package game_project.print;

public class GaBaBoPrint {
  public static void startMessage(){
    String str = "****************************************\n"+
                "             가위바위보 게임             \n"+
                "========================================\n"+
                "가위 바위 보 게임 : 1. 가위, 2. 바위, 3. 보\n";
    System.out.print(str);
  }

  public static void inputNumMessage(){
    String str = "========================================\n"+
                "번호 입력 : ";
    System.out.print(str);
  }

  public static void askContinueMessage(){
    System.out.print("계속하시겠습니까? (y/n) : ");
  }

  public static void sameMessage(String myRsp, String computerRsp){
    System.out.println("비겼습니다.\n당신은 "+ myRsp+"를 냈고 컴퓨터는 "+computerRsp+"를 냈습니다.");
  }

  public static void winMessage(String myRsp, String computerRsp){
    System.out.println("당신이 이겼습니다😏\n당신은 "+ myRsp+"를 냈고 컴퓨터는 "+computerRsp+"를 냈습니다.");
  }

  public static void loseMessage(String myRsp, String computerRsp){
    System.out.println("당신이 졌습니다😞\n당신은 "+ myRsp+"를 냈고 컴퓨터는 "+computerRsp+"를 냈습니다.");
  }
}

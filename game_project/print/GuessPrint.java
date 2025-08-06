package game_project.print;

public class GuessPrint {
  private static String str;
  public static void guessMessage(){
    str = "어떤 숫자일까요? 알아 맞혀 보세요! (1-10)\n"+
          "---------------------------------------\n"+
          "숫자입력 : ";
    System.out.print(str);
  }

  public static void correctMessage(int number){
    str = "맞혔습니다! 나의 숫자는 "+number+"입니다";
    System.out.println(str);
  }

  public static void wrongMessage(){
    str = "아닙니다. 다시 맞혀보세요! 다시 입력 : ";
    System.out.print(str);
  }
}

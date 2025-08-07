package genericCollection.sec14;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapEx2 {
  public static void main(String[] args) {
    // 사용자로부터 영문단어=한글단어 형태의 entry를 입력받아 HashMap에 저장하는 로직 구현
    Scanner sc = new Scanner(System.in);
    Map<String, String> dict = new HashMap<>();
    
    while (true) {
      System.out.print("영단어,한글 형식으로 입력하세요 (종료:exit) : ");
      String input = sc.next();
      if (input.equals("exit")){
        break;
      }
      String[] inputArr = input.split(",");
      String engWord = inputArr[0].trim();
      String korWord = inputArr[1].trim();
      dict.put(engWord, korWord);
    }

    // 2. HashMap에 입력된 영단어를 검색할 수 있는 로직 구현
    // exit입력되면 종료
    // 없는단어 검색시 "사전에 없는 단어 입니다." 출력
    String input;
    while (true) {
      System.out.print("찾고 싶은 단어는? ");
      input = sc.next().trim();
      if (input.equals("exit")){
        System.out.println("종료합니다...");
        break;
      }
      else if (dict.get(input) != null){
        System.out.println(dict.get(input));
      } else {
        System.out.println(input+"는 없는 단어 입니다.");
      }
    }

    sc.close();
  }
}

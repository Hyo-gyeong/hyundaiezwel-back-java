package genericCollection.sec06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListExample {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<String> list = new ArrayList<>();
    int maxLength = 0;
    int maxLenIdx = 0;

    for (int i = 0; i < 4; i++){
      System.out.print("단어를 입력하세요>>");
      String input = sc.next();
      list.add(input);
      if (maxLength < input.length()){
        maxLength = input.length();
        maxLenIdx = i;
      }
    }

    for (String s : list){
      System.out.print(s+ " ");
    }
    System.out.println("-----------------------");
    System.out.println("가장 긴 단어는 : " + list.get(maxLenIdx));
    System.out.println("가장 긴 단어의 길이는 : " + maxLength);
    
    sc.close();
  }
}

package arrayType;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayInput {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] names = new String[5];

    System.out.println("이름 입력");
    for (int i = 0; i < names.length; i++){
      System.out.printf("names[%d] : ", i);
      names[i] = sc.next();
    }

    System.out.println("명단 출력");
    for (int i = 0; i < names.length; i++){
      System.out.printf("names[%d] = %s\n", i, names[i]);
    }


    sc.close();
  }
}

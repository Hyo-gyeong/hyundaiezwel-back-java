package arrayType;

import java.util.Arrays;

public class ArrayExer3 {
  public static void main(String[] args) {
    int randNum[] = new int[6];
    for (int i = 0; i < randNum.length; i++){
      randNum[i] = (int)(Math.random()*45 + 1);
    }

    System.out.print(Arrays.toString(randNum));
  }
}

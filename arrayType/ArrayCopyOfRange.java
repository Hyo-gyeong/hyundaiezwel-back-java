package arrayType;

import java.util.Arrays;

public class ArrayCopyOfRange {
  public static void main(String[] args) {
    // Arrays.copyOfRange(원본배열, 시작인덱스, 끝인덱스+1): 시작~끝 인덱스까지 생성
    int[] a = {12,2,4,13,412,24,23};
    int[] b = Arrays.copyOfRange(a, 3, 6);
    
    for (int i = 0; i < a.length; i++){
      System.out.print(a[i]+ " ");
    }
    System.out.println();
    for (int i = 0; i < b.length; i++){
      System.out.print(b[i]+ " ");
    }
  }
}

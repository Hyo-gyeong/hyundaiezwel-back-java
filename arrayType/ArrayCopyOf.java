package arrayType;

import java.util.Arrays;

public class ArrayCopyOf {
  public static void main(String[] args) {
    // Arrays.copyOf(원본배열, 복사되는 배열의 크기);
    int[] a = {1,2,3,4,5};
    int[] b = Arrays.copyOf(a, a.length);
    int[] b1 = Arrays.copyOf(a, 7); // 더 커서 남는건 0으로 채움
    int[] b2 = Arrays.copyOf(a, 2); // 맨 앞에서부터 해당 길이까지만 복사

    for (int i = 0; i < a.length; i++){
      System.out.print(a[i]+ " ");
    }
    System.out.println();
    for (int i = 0; i < b.length; i++){
      System.out.print(b[i]+ " ");
    }
    System.out.println();
    for (int i = 0; i < b1.length; i++){
      System.out.print(b1[i]+ " ");
    }
    System.out.println();
    for (int i = 0; i < b2.length; i++){
      System.out.print(b2[i]+ " ");
    }
    System.out.println();

    b[1] = 888;
    for (int i = 0; i < a.length; i++){
      System.out.print(a[i]+ " ");
    }
    System.out.println();
    for (int i = 0; i < a.length; i++){
      System.out.print(b[i]+ " ");
    }
  }
}

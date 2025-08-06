package arrayType;

public class ArraySystemCopy {
  public static void main(String[] args) {
    // System.arrayCopy(원본, 시작인덱스, 대상, 시작인덱스, 복사할 개수) : 맨 앞에서부터 복사해줌
    int[] a = { 1, 2, 3, 4, 5 };
    int[] b = new int[a.length];
    System.arraycopy(a, 0, b, 2, 3); // 시작점과 개수가 배열과 맞아야 함. 개수가 넘거나 인덱스가 넘으면 안됨

    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();
    for (int i = 0; i < b.length; i++) {
      System.out.print(b[i] + " ");
    }
  }
}

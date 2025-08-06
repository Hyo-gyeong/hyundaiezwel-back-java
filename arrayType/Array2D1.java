package arrayType;

public class Array2D1 {
  public static void main(String[] args) {
    // 2차원 배열 선언, 할당, 저장
    int[][] a = new int[][] {{1,2,3,4,5},
                             {6,7,8,9,10},
                             {11,12,13,14,15}};

    System.out.println(a[0][1]); //2

    for (int i = 0; i < a.length; i++){
      for (int j = 0; j < a[0].length; j++){
        System.out.print(a[i][j]+"\t");
      }
      System.out.println();
    }
  }
}

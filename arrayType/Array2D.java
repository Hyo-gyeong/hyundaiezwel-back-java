package arrayType;

public class Array2D {
  public static void main(String[] args) {
    // 다차원 배열 : 선언 및 생성
    int[][] score = new int[5][3]; // 행렬
    for (int i = 0 ; i < score.length; i++){ //행
      for (int j = 0; j < score[0].length; j++){ //열
        System.out.print(score[i][j]);
      }
      System.out.println();
    }

  }
}

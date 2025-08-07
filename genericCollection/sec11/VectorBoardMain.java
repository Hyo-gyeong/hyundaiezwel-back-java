package genericCollection.sec11;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class VectorBoardMain {
  public static void main(String[] args) {
    // List interface를 통해서 Vector참조
    // Vector는 ArrayList와 내부 구조 동일 - 사용법 동일
    // 단, thread를 활용하는 경우 동기화 진행을 따로하지 않아도 됨 - 동시접근이 안되도록 막아줌
    List<Board> list = new Vector<>(); // The Vector class implements a growable array of objects.
                                      // Like an array, it contains components that can be accessed using an integer index. 
    // main 단일 thread이기 때문에 위에서 아래로 순차적으로 진행됨
    list.add(new Board("제목1", "내용1", "글쓴이1"));
    list.add(new Board("제목2", "내용2", "글쓴이2"));
    list.add(new Board("제목3", "내용3", "글쓴이3"));
    list.add(new Board("제목4", "내용4", "글쓴이4"));
    list.add(new Board("제목5", "내용5", "글쓴이5"));
    list.add(new Board("제목6", "내용6", "글쓴이6"));
    list.add(new Board("제목7", "내용7", "글쓴이7"));
    list.add(new Board("제목8", "내용8", "글쓴이8"));

    list.remove(2);
    list.remove(3);

    for(int i = 0; i < list.size(); i++){
      Board board = list.get(i);
      System.out.println(board.subject+"\t"+board.content+"\t"+board.writer);
    }
  }
}

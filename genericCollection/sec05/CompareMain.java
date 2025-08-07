package genericCollection.sec05;

public class CompareMain {
  public static void main(String[] args) {
    // 제네릭 클래스 및 제네릭 메서드 사용 예제
    // 객체 생성
    Pair<Integer, String> pair1 = new Pair<Integer,String>(1, "사과");
    Pair<Integer, String> pair2 = new Pair<>(1, "사과");
    
    // boolean rslt1 = Util.compare(pair1, pair2); // 파라미터 구체화 생략한 경우
    boolean rslt2 = Util.<Integer, String>compare(pair1, pair2);
    
    if (rslt2){
      System.out.println("같습니다");
    }else{
      System.out.println("다릅니다");
    }
    
    Pair<String, String> pair3 = new Pair<String,String>("user1", "사과");
    Pair<String, String> pair4 = new Pair<>("user2", "사과");

    boolean rslt3 = Util.compare(pair3, pair4);
    
    if (rslt3){
      System.out.println("같습니다");
    }else{
      System.out.println("다릅니다");
    }
  }
}

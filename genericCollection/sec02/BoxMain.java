package genericCollection.sec02;

public class BoxMain {
  public static void main(String[] args) {
    Box<String> box1 = new Box<String>();
    box1.set("123");
    String str = box1.get(); // 강제 형변환 필요 없음
    System.out.println(str);
    
    // 앞에서 지정한 Integer를 가지고 유추해서 넣어줌
    // 앞에서 Integer를 쓰면 뒤에서는 생략 가능
    // 따라서 맨 앞쪽은 생략하면 안됨
    Box<Integer> box2 = new Box<>();
    box2.set(123);
    Integer num = box2.get();
    System.out.println(num);
  }
}

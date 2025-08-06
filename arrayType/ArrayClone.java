package arrayType;

public class ArrayClone {
  public static void main(String[] args) {
    // Object(최상위 객체 클래스) clone메소드
    int[] a = {1,2,3,4}; // 배열 객체는 객체참조 변수고 Object를 상속 받아서 만들었기 때문에 clone 사용 가능
    int[] b = a.clone();
    
    for (int i = 0; i < a.length; i++){
      System.out.print(a[i] + " ");
    }
    System.out.println();
    for (int i = 0; i < b.length; i++){
      System.out.print(b[i] + " ");
    }
    
    System.out.println();
    b[0] = 99;
    for (int i = 0; i < a.length; i++){
      System.out.print(a[i] + " ");
    }
    System.out.println();
    for (int i = 0; i < b.length; i++){
      System.out.print(b[i] + " ");
    }

    System.out.println();
    System.out.println("a 주소 : " + a);
    System.out.println("b 주소 : " + b);
  }
}

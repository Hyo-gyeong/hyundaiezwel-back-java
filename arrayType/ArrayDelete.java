package arrayType;

public class ArrayDelete {
  public static void main(String[] args) {
    int[] num = {1,2,3,4,5};
    // num의 원소값은 유지하고 크기는 10인 배열
    int[] newNum = new int[10];

    // num원소값 newNum에 저장
    for (int i = 0; i < num.length; i++){
      newNum[i] = num[i];
    }
    
    for (int i = 0; i < newNum.length; i++){
      System.out.print(newNum[i]+ " ");
    }
    System.out.println();
    for (int i = 0; i < num.length; i++){
      System.out.print(num[i]+ " ");
    }
    System.out.println();

    num = newNum; // num과 newNum은 같은 객체 참조와 동시에 num은 참조를 잃고 GC가 메모리 할당을 풀어버림
                  // num = null;이렇게 해도 참조 값이 없어짐

    for (int i = 0; i < newNum.length; i++){
      System.out.print(newNum[i]+ " ");
    }
    System.out.println();
    for (int i = 0; i < num.length; i++){
      System.out.print(num[i]+ " ");
    }

    num = null; // num이 참조하는 배열의 참조값이 num에서만 사라짐, newNum은 여전히 가지고있음.
    System.out.println();
    for (int i = 0; i < newNum.length; i++){
      System.out.print(newNum[i]+ " ");
    }
    System.out.println();
    // java.lang.NullPointerException: Cannot read the array length because "num" is null
    // for (int i = 0; i < num.length; i++){
    //   System.out.print(num[i]+ " ");
    // }
  }
}

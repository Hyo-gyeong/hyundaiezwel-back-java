package oopException.sec01;

public class NullPointerExceptionEx {
  public static void main(String[] args) {
    // null을 참조하는 객체변수를 통해 메서드 접근할 때 발생하는 예외
    String data = null;
    int[] arr = {1,2,3};
    String data1 = "100";
    String data2 = "a100";

    // 오류나면서 프로그램 종료됨
    // System.out.println(data.toString()); //  Cannot invoke "String.toString()" because "data" is null
    // System.out.println(arr[5]); // Index 5 out of bounds for length 3

    int value1 = Integer.parseInt(data1);
    int value2 = Integer.parseInt(data2); // 정수로 변환 불가능한 예외 발생, java.lang.NumberFormatException

    System.out.println(value1 + value2);
  }
}

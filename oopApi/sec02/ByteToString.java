package oopApi.sec02;

public class ByteToString {
  public static void main(String[] args) {
    // byte 배열의 수치를 문자열로 변환
    byte[] bytes = {72,101,108,108,111,32,74,97,118,97};
    String str1 = new String(bytes); // Constructs a new String by decoding the specified array of bytes using the default charset.
    System.out.println(str1);

    String str2 = new String(bytes,6,4); // Constructs a new String by decoding the specified array of bytes using the default charset.
    System.out.println(str2);
  }
}

package oopApi.sec02;

import java.io.IOException;

public class KeyBoardToStringEx {
  public static void main(String[] args) throws IOException {
    // 사용자로부터 키코드 입력받고 문자열로 출력
    byte[] bytes = new byte[100];

    System.out.print("입력: ");
    int readByteNo = System.in.read(bytes); // exception처리해줘야함
    // ## keyboard로부터의 입력은 입력 종료기호인 enter까지 전달됨 ##
    // enter = \r\n의 두 키의 조합 : acii 13, 10 => 2바이트가 더 들어오게 됨
    System.out.println(readByteNo + " 바이트"); // 몇 바이트를 읽었는지 (개행 2바이트 포함)
    String str = new String(bytes, 0, readByteNo-2);
    System.out.println(str); // 몇 바이트를 읽었는지 (개행 2바이트 포함)
  }
}

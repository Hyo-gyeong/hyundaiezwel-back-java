package oopApi.sec03;

import java.util.StringTokenizer;

public class StringToken {
  public static void main(String[] args) {
    // StringTokenizer 클래스 활용
    // 메소드 : countTokens() - 남아있는 토큰 수
            // hasMoreTokens() - 남아있는 토큰이 있는지 여부
            // nextToken() - 토큰을 하나씩 꺼내옴
    String text = "홍길동/이수홍/박연수";
    // st에는 토큰화된 문자열들이 저장되어 있음
    StringTokenizer st = new StringTokenizer(text, "/");
    // 토큰 수 확인
    int cntToken = st.countTokens();
    System.out.println("토큰 수 : " + cntToken); //3

    while (st.hasMoreTokens()){
      System.out.println(st.nextToken());
    }
  }
}

package oopApi.sec06;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateEx {
  public static void main(String[] args) {
    // 날짜 시간 관련 클래스
    // 날짜 정보를 객체간에 주고 받을 때 주로 사용
    Date now = new Date();
    System.out.println(now.toString()); // date클래스도 Object를 상속받았을 테니까 toString사용 가능

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");// format만 생성해주는 클래스
    String strNow2 = sdf.format(now); // Date객체가 아닌 문자열 반환
    System.out.println(strNow2);
  }
}

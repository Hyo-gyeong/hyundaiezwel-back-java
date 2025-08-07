package oopApi.sec06;

import java.time.LocalDateTime;
import java.util.Calendar;

public class CalendarEx {
  public static void main(String[] args) {
    // Calnedar class
    Calendar now = Calendar.getInstance(); // Gets a calendar using the default time zone and locale.

    int year = now.get(Calendar.YEAR);
    int month = now.get(Calendar.MONTH);
    int day = now.get(Calendar.DAY_OF_MONTH);

    int week = now.get(Calendar.DAY_OF_WEEK);

    String strWeek = null;

    switch (week) {
    case Calendar.SUNDAY:
        strWeek = "일";
        break;
    case Calendar.MONDAY:
        strWeek = "월";
        break;
    case Calendar.TUESDAY:
        strWeek = "화";
        break;
    case Calendar.WEDNESDAY:
        strWeek = "수";
        break;
    case Calendar.THURSDAY:
        strWeek = "목";
        break;
    case Calendar.FRIDAY:
        strWeek = "금";
        break;
    case Calendar.SATURDAY:
        strWeek = "토";
        break;
    }

    int amPm = now.get(Calendar.AM_PM);
    String strAmPm = null;
    if (amPm == Calendar.AM){
      strAmPm = "오전";
    } else {
      strAmPm = "오후";
    }

    int hour = now.get(Calendar.HOUR); // 시 (12시간제)
    int minute = now.get(Calendar.MINUTE);
    int second = now.get(Calendar.SECOND);

    System.out.print(year + "년 ");
    System.out.print(month + "월 ");
    System.out.println(day + "일 ");
    System.out.println(strWeek + "요일 ");
    System.out.print(strAmPm + " ");
    System.out.print(hour + "시 ");
    System.out.print(minute + "분 ");
    System.out.println(second + "초 ");

    LocalDateTime n = LocalDateTime.now();
    System.out.println(n.getYear()+"년 "+n.getMonthValue()+"월 " +n.getDayOfMonth()+"일");
    System.out.println("내일은 " + n.plusDays(1) + "일 입니다.");
    System.out.println("한시간 이전 시잔은 " + n.minusHours(1) + "시 였습니다.");
    System.out.println("다음주는 " + n.plusWeeks(1) + "일 입니다.");
    System.out.println("오늘은 올해의 " + n.getDayOfYear() + "번째 날입니다.");
  }
}

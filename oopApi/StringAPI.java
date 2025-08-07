package oopApi;

public class StringAPI {
  public static void main(String[] args) {
    String ssn = "010231-123232";
    char sex = ssn.charAt(7);

    switch (sex) {
      case '1':
      case '3':
        System.out.println("남자");
        break;
      case '2':
      case '4':
        System.out.println("여자");
        break;
    }

    String title = "자바 프로그래밍";
    System.out.println(title.indexOf("프로그래밍")); // index위치 3부터 시작
    System.out.println(title.indexOf("java")); // -1 반환 : 해당 문자열을 포함하고 있지 않음
    System.out.println(title.replace("자바", "Java")); // 문자열을 찾아서 대체 문자열로 변경 후 새로운 문자열 반환 (원본변경x)
    System.out.println(title.substring(3)); // 3번 인텍스부터 끝까지 추출
    System.out.println(title.substring(3,5)); // 3번 인텍스부터 4번 인덱스까지 추출
    System.out.println(String.valueOf(true)); // true를 문자열 "true"로 바꾸겠다
    System.out.println(title.split(" ")[0]); // 주어진 기중 문자를 활용하여 문자열을 분리하고 배열로 반환

    String str = "홍길동&이몽룡,성춘향,김자바-김길동";
    String[] names = str.split("&|,|-");// |로 구분
    System.out.println(names[2]);
  }
}

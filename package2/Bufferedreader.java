package package2;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Bufferedreader {
  public static void main(String[] args) throws IOException{
    // System.in: 바이트 단위의 기본 입력 스트림 (표준 입력)
    // InputStreamReader: 바이트 → 문자(char)로 변환 (한글 같은 문자 처리 가능)
    // BufferedReader: 문자 스트림을 버퍼에 모아서 효율적으로 한 줄씩 읽도록 도와줌
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 한 줄 입력 후 공백 기준으로 토큰 분리
    String line = br.readLine();
    // StringTokenizer는 문자열을 구분자(delimiter)를 기준으로 나누는 클래스
    // StringTokenizer st = new StringTokenizer(sentence, "-,|"); // 쉼표, 하이픈, 파이프 기호를 구분자로 사용
    // 기본 구분자는 공백
    // 📌 StringTokenizer의 주요 메서드
    // 1. hasMoreTokens()
      // 더 읽을 토큰이 남아 있는지 확인하는 메서드.
      // 반환값: true/false
    // 2. nextToken()
      // 다음 토큰을 반환합니다.
      // 반환값: String 타입의 토큰
    // 3. countTokens()
      // 남아있는 토큰의 개수를 반환합니다.
      // 반환값: 남은 토큰 개수 (int)
    StringTokenizer st = new StringTokenizer(line);
    while (st.hasMoreTokens()) {
        System.out.println(st.nextToken());
    }

  }
}

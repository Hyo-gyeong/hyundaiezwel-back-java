package InterfacePackage.sec02;

public interface RemoteControl {
  // 상수 필드 선언 : public static final은 자동으로 컴파일러에 의해 추가
  int MAX_VOLUME = 10;
  int MIN_VOLUME = 0;
  
  // 추상메서드 선언 : public abstract 생략되어도 컴파일러에 의해서 추가가됨
  void turnOn();
  void turnOff();
  void setVolume(int volume);

  // 디폴트 메서드 선언 및 구현
  // default키워드 반드시 붙여야 함 != 접근 제한자, 인터페이스지만 구현을 여기서 하겠다는 의미의 default
  // 기본적으로 public 접근 제한 받음
  default void setMute(boolean mute){
    if (mute){
      System.out.println("무음 처리합니다.");
    } else {
      System.out.println("무음 해제합니다.");
    }
  }

  // 정적 메서드 선언 및 구현 : 객체 없이 인터페이스만으로 호출 가능한 메서드
  // static 키워드 사용, 실행 블록이 있음
  // 기본 public 접근 제한
  static void showRemote(){
    System.out.println("인터페이스 내 static 메소드 출력");
  }
  static void changeBattery(){
    System.out.println("베터리를 교체합니다.");
  }
}

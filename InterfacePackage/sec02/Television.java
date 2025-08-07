package InterfacePackage.sec02;

public class Television implements RemoteControl {
  private int volume;

  @Override
  public void turnOn() {
    System.out.println("TV를 켭니다.");
  }
  
  @Override
  public void turnOff() {
    System.out.println("TV를 끕니다.");
  }
  
  @Override
  public void setVolume(int volume) {
    if (volume >= RemoteControl.MAX_VOLUME){ // 인터페이스 이름으로 접근 가능
      this.volume = RemoteControl.MAX_VOLUME;
    } else if (volume <= RemoteControl.MIN_VOLUME){
      this.volume = RemoteControl.MIN_VOLUME;
    } else {
      this.volume = volume;
    }
    System.out.println("현재 TV 볼륨 : " + this.volume);
  }

  // interface의 default method
  // 재정의 가능
  @Override
  public void setMute(boolean mute){
    if (mute){
      System.out.println("TV 무음 처리합니다.");
    } else {
      System.out.println("TV 무음 해제합니다.");
    }
  }
  
}

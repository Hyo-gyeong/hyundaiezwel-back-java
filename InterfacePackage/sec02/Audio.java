package InterfacePackage.sec02;

public class Audio implements RemoteControl {
  // 멤버필드
  private int volume;
  private boolean mute;

  @Override
  public void turnOn() {
    System.out.println("Audio를 켭니다.");
  }

  @Override
  public void turnOff() {
    System.out.println("Audio를 끕니다.");
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
    System.out.println("현재 Audio 볼륨 : " + this.volume);
  }

  // 재정의 여부는 선택사항
  @Override
  public void setMute(boolean m){
    RemoteControl.super.setMute(m);
  }
  
}

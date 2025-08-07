package oopClass.sec18;

public class Car {
  private int speed;
  private boolean stop;
  
    // private 멤버 필드에 접근하려면 클래스 내에서 접근해야함
    // private 멤버 필드의 값을 수정하기 위한 setter, 값 반환을 위한 getter필요

    // setter
    public void setSpeed(int speed) {
      if (speed > 0){
        this.speed = speed;
      } else{
        this.speed = 0;
      }      
    }
    public void setStop(boolean stop) {
      this.stop = stop;
      this.speed = 0;
    }

    // getter
    public int getSpeed() {
      return speed;
    }
    public boolean isStop() {
    return stop;
  }
  
}

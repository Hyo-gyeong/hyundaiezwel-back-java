package oopClass.sec06;

public class Circle {
  int radius;

  public void setCircle(int r){
    this.radius = r;
  }

  public float area(){
    return (float) (radius*radius*Math.PI);
  }
}

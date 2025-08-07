package oopInheritance.sec04;

public class Manager extends Employee{
  private String position;
  
  public Manager(String empNo, String name, String part, String position){
    super(empNo, name, part);
    this.position = position;
  }

  @Override
  public String toString(){
    // super 레퍼런스 : 부모클래스의 멤버를 참조할 때 사용할 수 있음
    return super.toString() + "\t" + this.position;
  }
}

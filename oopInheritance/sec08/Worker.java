package oopInheritance.sec08;

public class Worker {
  private String residentNum;
  private String name;

  public Worker(String residentNum, String name){
    this.residentNum = residentNum;
    this.name = name;
  }

  @Override
  public String toString(){
    String str = "이름 : " + this.name + "\n" + 
                "주민번호 : " + this.residentNum + "\n";
    return str;
  }
}

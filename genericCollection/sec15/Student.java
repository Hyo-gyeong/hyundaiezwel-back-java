package genericCollection.sec15;

public class Student {
  // Map Collection에 저장될 데이터의 key로 사용할 클래스
  private int stdNo;
  private String stdName;

  public Student(int stdNo, String stdName) {
    this.stdNo = stdNo;
    this.stdName = stdName;
  }
  public int getStdNo() {
    return stdNo;
  }
  public void setStdNo(int stdNo) {
    this.stdNo = stdNo;
  }
  public String getStdName() {
    return stdName;
  }
  public void setStdName(String stdName) {
    this.stdName = stdName;
  }

  @Override
  public int hashCode(){
    return this.getStdNo() + this.getStdName().hashCode();
  }

  @Override
  public boolean equals(Object obj){
    if (obj instanceof Student){
      Student std = (Student) obj;
      return (std.getStdNo() == this.getStdNo()) && std.getStdName().equals(this.getStdName());
    } else {
      return false;
    }
  }
  
}

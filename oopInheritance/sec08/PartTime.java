package oopInheritance.sec08;

public class PartTime extends Worker {
  private int hours;
  private int unitPrice;

  public PartTime(String residentNum, String name, int hours, int unitPrice){
    super(residentNum, name);
    this.hours = hours;
    this.unitPrice = unitPrice;
  }

  public int calculatePayment(){
    return this.hours * this.unitPrice;
  }

  @Override
  public String toString(){
    String str = super.toString() + 
                "시급 : " + unitPrice + "\n"+
                "근무시간 : " + hours + "\n" +
                "총 지불액 : " + calculatePayment();
    return str;
  }
}

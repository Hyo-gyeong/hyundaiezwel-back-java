package genericCollection.sec02;

public class Box<T> { // 타입이 결정되지 않은 파라미터 받음
  private T tObj;
  
  public void set(T obj){
    this.tObj = obj;
  }

  public T get(){
    return this.tObj;
  }
  
}

package genericCollection.sec04;

public class Box<T> {
  private T tObj;
  
  public void set(T obj){
    this.tObj = obj;
  }

  public T get(){
    return this.tObj;
  }
  
}

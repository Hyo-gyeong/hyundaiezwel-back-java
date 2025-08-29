package d_datastructure.list;


public class Node<E> {
    private Node<E> next; // 단방향
    private E data;

    public Node(E e){
        data = e;
    }

    public Node<E> next(){
        return next;
    }

    public void next(Node<E> next){
        this.next = next;
    }

    public E data(){
        return data;
    }

    public void data(E e){
        this.data = e;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
    
}

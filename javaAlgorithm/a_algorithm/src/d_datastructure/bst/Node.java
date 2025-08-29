package d_datastructure.bst;

public class Node<E> {
    private E data;
    private Node<E> left;
    private Node<E> right;

    public Node(E data){
        super();
        this.data = data;
    }

    public Node<E> left(){
        return left;
    }

    public Node<E> right(){
        return right;
    }

    public void left(Node<E> child){
        this.left = child;
    }

    public void right(Node<E> child){
        this.right = child;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }

}

package d_datastructure.set;

import java.util.Arrays;
import java.util.Iterator;

import d_datastructure.list.Node;

@SuppressWarnings("unchecked")
public class _HashSet_Chaining<E> implements Iterable<E>{
    private int arraySize = 2;
    private Object[] table;
    private int size = 0;

    public _HashSet_Chaining(){
        this.table = new Object[arraySize];
    }

    public _HashSet_Chaining(int initialCapacity){
        this.table = new Object[initialCapacity];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return this.size;
    }

    // 해시 함수의 원칙
    // 같은 값이 들어오면 언제나 같은 값을 반환해야 함
    // 다른 값이 들어오면 언제나 다른 값을 반환해야 함
    // 해시 충돌 : 다른 값이 들어왔는데 해시 함수가 같은 해시값을 반환하는 경우
    private int hash(E e){
        int hashCode = Math.abs(e.hashCode());
        return hashCode % arraySize; // 0~5
    }

    public boolean add(E e){
        if (size == arraySize){
            resize();
        }
        if (!addNode(e)) return false;
        size++;
        return true;
    }

    private void resize(){
        Object[] temp = Arrays.copyOf(table, arraySize);
        arraySize *= 2; //해시값 바뀜
        table = new Object[arraySize]; // 크기 늘림
        for (int i = 0; i < temp.length; i++){
            if (temp[i] == null){
                continue;
            }
            Node<E> link = (Node<E>) temp[i];
            while (link != null){
                addNode(link.data());
                link = link.next();
            }
        }
    }

    private boolean addNode(E e){
        // node가 들어갈 table index
        int index = hash(e);
        // 추가할 노드 데이터 넣어서 준비
        Node<E> node = new Node<>(e);
        // index를 이용해서 table 시작점 잡기 □*→*→*→*→.. 이렇게 들어갈 시작점
        Node<E> head = (Node<E>) table[index];
        if (head == null){ // 시작 테이블 자체가 비면 그냥 바로 넣기
            table[index] = node;
            return true;
        }
        // 테이블 인덱스가 같아서 노드가 줄줄이 달려야 하는 상황
        Node<E> link = head;
        while (link.next() != null){
            if (link.data().equals(e)){ // 같은 인덱스에 같은 값이 들어가면 안되니까 false return
                return false;
            }
            link = link.next();
        }
        // 맨 마지막 노드와 인수값 비교
        if (link.data().equals(e)){
            return false;
        }
        link.next(node);
        return true;
    }

    public boolean remove(E e){
        int index = hash(e);
        Node<E> node = (Node<E>) table[index];
        
        // 없는 값을 삭제하려고 하니까 false반환
        if (node == null) return false;
        if (node.data().equals(e)){
            // 다음 값을 next로 link를 걸게 한 다음 삭제됨
            table[index] = node.next();
            size--;
            return true;
        }
        Node<E> next = node.next();
        Node<E> prev = node;
        while (next != null){
            if (next.data().equals(e)){
                prev.next(next.next());
                size--;
                return true;
            }
            prev = next;
            next = next.next();
        }
        return false; // 노드 끝까지 찾아도 값이 없음
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < table.length; i++){
            if (table[i] == null){
                continue;
            }
            Node<E> link = (Node<E>) table[i];
            while (link != null){
                sb.append(link.data()).append(", ");
                link = link.next();
            }
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
       return new Iterator<E>() {
        private int cnt = 0;
        private int rowPointer = -1;
        private Node<E> prev = new Node<E>(null); // caching

        @Override
        public boolean hasNext() {
            return cnt < size;
        }

        @Override
        public E next() {
            // next호출 직전 노드를 저장해 놨으니까 바로 다음 노드를 주면 됨
            // prev가 null인 노드이기 때문에 이 if문은 절대로 처음엔 걸리지 않음
            if (prev.next() != null){ 
                E data = prev.data();
                prev = prev.next();
                cnt++;
                return data;
            }
            do {
                rowPointer++;
            } while (table[rowPointer] == null);
            // table[index]가 null이 아닌 점을 찾으면 해당 table의 값을 우선 반환해야함
            // 그 다음 위의 if문에서 노드값들을 하나씩 전달
            prev = (Node<E>) table[rowPointer];
            E data = prev.data();
            cnt++;
            return data; 
        }
       };
    }
    
}

package d_datastructure.set;

import java.util.Arrays;
import java.util.Iterator;

import d_datastructure.list._LinkedList;

// 모듈화 되어있던 _LinkedList를 사용해서 HashSet구현
@SuppressWarnings("unchecked")
public class _HashSet_P3<E> implements Iterable<E>{
    private int arraySize = 3;
    private Object[] table;
    private int size;

    public _HashSet_P3(){
        this.table = new Object[arraySize];
    }

    public _HashSet_P3(int initialCapacity){
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
            _LinkedList<E> row = (_LinkedList<E>) temp[i];
            for (E e : row){
                addNode(e);
            }
        }
    }

    private boolean addNode(E e){
        // node가 들어갈 table index
        int index = hash(e);
        
        // Node를 LinkedList로 변경
        _LinkedList<E> row = (_LinkedList<E>) table[index];
        if (row == null){ // 시작 테이블 자체가 비면 그냥 바로 넣기
            _LinkedList<E> newRow = new _LinkedList<>();
            newRow.add(e);
            table[index] = newRow;
            return true;
        }
        if (row.contains(e)){
            return false;
        }
        row.add(e);
        return true;
    }

    public boolean remove(E e){
        int index = hash(e);
        _LinkedList<E> row = (_LinkedList<E>) table[index];
        
        // 없는 값을 삭제하려고 하니까 false반환
        if (row == null) return false;
        if (!row.contains(e)){
            return false;
        }
        row.remove(row.indexOf(e));
        if (row.isEmpty()){
            row = null;
        }
        size--;
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
            _LinkedList<E> row = (_LinkedList<E>) table[i];
            for (E e : row){
                sb.append(e).append(", ");
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
        private _LinkedList<E> row = new _LinkedList<E>(); 
        private Iterator<E> rowIterator = row.iterator();

        @Override
        public boolean hasNext() {
            return cnt < size;
        }

        @Override
        public E next() {
            // next호출 직전 노드를 저장해 놨으니까 바로 다음 노드를 주면 됨
            if (rowIterator.hasNext()){ 
                cnt++;
                return rowIterator.next();
            }
            do {
                rowPointer++;
            } while (table[rowPointer] == null);
            // table[index]가 null이 아닌 점을 찾으면 해당 table의 값을 우선 반환해야함
            // 그 다음 위의 if문에서 노드값들을 하나씩 전달
            row = (_LinkedList<E>) table[rowPointer];
            rowIterator = row.iterator();
            cnt++;
            return rowIterator.next(); 
        }
       };
    }
    
}

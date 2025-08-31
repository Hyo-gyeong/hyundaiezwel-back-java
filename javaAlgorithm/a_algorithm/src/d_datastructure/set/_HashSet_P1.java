package d_datastructure.set;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class _HashSet_P1<E> {

    private Object[] table;
    private int arraySize = 6; // 해시충돌을 일으켜보기 위해 일부러 작게 잡음
    private int size;

    public _HashSet_P1(){
        this.table = new Object[arraySize];
    }

    public _HashSet_P1(int initialCapacity){
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
        if (size == arraySize){ // 가득 참
            resize();
        }

        int index = hash(e);
        if (table[index] != null){
            return false;
        }
        table[index] = e;
        size++;
        return true;
    }

    private void resize(){
        arraySize *= 2; //해시값 바뀜
        Object[] temp = new Object[arraySize];
        for (int i = 0; i < table.length; i++){
            if (table[i] == null){
                continue;
            }
            int index = hash((E)table[i]);
            temp[index] = table[i];
        }
        table = temp;
    }

    public boolean remove(E e){
        int index = Math.abs(hash(e));
        if (table[index] == null){
            return false;
        }
        table[index] = null;
        size--;
        return true;
    }


    @Override
    public String toString() {
        return "_HashSet_P1 [table=" + Arrays.toString(table) + "]";
    }
    
}

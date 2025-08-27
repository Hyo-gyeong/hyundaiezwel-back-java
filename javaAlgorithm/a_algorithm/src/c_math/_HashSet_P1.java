package c_math;

import java.util.Arrays;
import java.util.Iterator;

public class _HashSet_P1<E> {
    private Object[] table;
    private int arraySize = 6;
    private int size;

    public _HashSet_P1(){
        this.table = new Object[arraySize];
    }
    public _HashSet_P1(int initialCapacity){
        arraySize = initialCapacity;
        this.table = new Object[arraySize];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return this.size;
    }

    private int hash(E e){
        int hashCode = Math.abs(e.hashCode());
        return hashCode % arraySize;
    }

    public boolean add(E e){
        if (size == arraySize){ // 꽉차면
            // 크기 늘리고
            // 배열 늘려서
            // 늘린 배열에 복사
            arraySize *= 2;
            Object[] temp = new Object[arraySize];
            for (int i = 0; i < table.length; i++){
                if (table[i] == null){ // 없는 값은 건너뛰기
                    continue;
                }
                int idx = hash(e);
                temp[idx] = table[i];
            }
            table = temp; // 같은 변수명에 업데이트한 값으로 바꿔 줘야함
        }
        else {
            int idx = hash(e);
            if (table[idx] != null){
                return false;
            }
            table[idx] = e;
            size++;
        }
        return true;
    }

    public boolean remove(E e){
        int idx = hash(e);
        if (table[idx] == null){
            return false; //삭제할 값이 없음
        } else {
            table[idx] = null;
            size--;
            return true;
        }
    }
}

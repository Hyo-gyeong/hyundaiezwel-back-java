package d_datastructure.list;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

// 인터페이스 직접 구현해보기
public class _ArrayList<E> implements Iterable<E>{
    private Object[] elementData;
    private int size;
    private int arraySize = 10;

    public _ArrayList(){
        elementData = new Object[arraySize];
    }
    
    public _ArrayList(int initialCapacity){
        this.arraySize = initialCapacity;
        elementData = new Object[arraySize];
    }

    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean add(E e){
        if (size < arraySize){
            elementData[size] = e;
            size++;
            return true;
        }
        arraySize *= 2;
        elementData = Arrays.copyOf(elementData, arraySize);
        elementData[size] = e;
        size++;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("인덱스 범위를 벗어났습니다.");
        }
        return (E) elementData[index];
    }
    
    @SuppressWarnings("unchecked")
    // Replaces the element at the specified position in this list with the specified element.
    public E set(int index, E element){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("인덱스 범위를 벗어났습니다.");
        }
        E prevElement = (E) elementData[index];
        elementData[index] = element;
        return prevElement;
    }
    
    @SuppressWarnings("unchecked")
    // Removes the element at the specified position in this list.
    // Shifts any subsequent elements to the left (subtracts one from their indices)
    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("인덱스 범위를 벗어났습니다.");
        }
        E prevElement = (E) elementData[index];
        for (int i = index; i < size-1; i++){
            elementData[i] = elementData[i+1];
        }
        return prevElement;
    }

    @Override
    public String toString() {
        return "_ArrayList [elementData=" + Arrays.toString(elementData) + "]";
    }

    // @Override
    // public Iterator<E> iterator() {
    //     return new _Iterator();
    // }

    // 외부에서는 iterator만 사용하기 때문에 클래스로 만들 필요 없음
    // class _Iterator implements Iterator<E>{
    //     private int pointer = 0; // index 탐색

    //     @Override
    //     public boolean hasNext() {
    //         return pointer < size ? true : false;
    //     }

    //     @Override
    //     public E next() {
    //         @SuppressWarnings("unchecked")
    //         E res = (E) elementData[pointer];
    //         pointer++;
    //         return res;
    //     }
        
    // }
   

    // 익명 내부 클래스로 구현
    // 한 번만 쓰는 구현체를 만들 때 유용
    // 내부 동작 로직은 내부 클래스에서 처리하므로 컬렉션 구조를 감출 수 있음 - 캡슐화 강화(은닉)
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>(){
            private int pointer = 0; // index 탐색

            @Override
            public boolean hasNext() {
                return pointer < size ? true : false;
            }

            @Override
            public E next() {
                @SuppressWarnings("unchecked")
                // 바깥 클래스의 private 필드에 바로 접근할 수 있으므로, 컬렉션의 데이터를 안전하게 순회 가능
                E res = (E) elementData[pointer];
                pointer++;
                return res;
            }
        };
    }


}

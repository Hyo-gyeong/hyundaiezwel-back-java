package d_datastructure.map;

import java.util.Arrays;

import d_datastructure.list._LinkedList;
import d_datastructure.set._HashSet_P3;

@SuppressWarnings("unchecked")
public class _HashMap<K,V> {

    private int size = 0;
    private Object[] table;
    private int arraySize = 10;
    private _HashSet_P3<Entry<K,V>> entrySet = new _HashSet_P3<>();

    public _HashMap(){
        this.table = new Object[arraySize];
    }
    
    public _HashMap(int initialCapacity){
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
    private int hash(Object e){
        int hashCode = Math.abs(e.hashCode());
        return hashCode % arraySize; // 0~5
    }

    private V addEntry(Entry<K,V> e){
        // node가 들어갈 table index
        int index = hash(e);
        
        // Node를 LinkedList로 변경
        _LinkedList<Entry<K,V>> row = (_LinkedList<Entry<K,V>>) table[index];
        if (row == null){ // 시작 테이블 자체가 비면 그냥 바로 넣기
            _LinkedList<Entry<K,V>> newRow = new _LinkedList<>();
            newRow.add(e);
            table[index] = newRow;
            entrySet.add(e);
            return null; //?
        }
        if (row.contains(e)){
            int idx = row.indexOf(e);
            entrySet.remove(row.get(idx));

            V prev = row.get(idx).getValue();
            row.remove(idx);
            row.add(e);
            entrySet.add(e);
            return prev;
        }
        row.add(e);
        entrySet.add(e);
        return null;
    }

    private void resize(){
        Object[] temp = Arrays.copyOf(table, arraySize);
        arraySize *= 2; //해시값 바뀜
        table = new Object[arraySize]; // 크기 늘림
        for (int i = 0; i < temp.length; i++){
            if (temp[i] == null){
                continue;
            }
            _LinkedList<Entry<K,V>> row = (_LinkedList<Entry<K,V>>) temp[i];
            for (Entry<K,V> e : row){
                addEntry(e);
            }
        }
    }

    public V put(K key, V value){
        if (size == arraySize){
            resize();
        }
        V res = addEntry(new Entry<K,V>(key, value));
        size++;
        return res;
    }
    
    public V get(Object key){
        Entry<K, V> dummy = new Entry<K,V>((K) key, null);
        int index = hash(dummy);
        _LinkedList<Entry<K,V>> row = (_LinkedList<Entry<K,V>>) table[index];

        if (row == null){
            return null;
        }
        if (!row.contains(dummy)){
            return null;
        }
        return row.get(row.indexOf(dummy)).getValue(); 
    }

    public V remove(K key){
        Entry<K,V> dummy = new Entry<K,V>(key, null);
        int index = hash(dummy);
        _LinkedList<Entry<K,V>> row = (_LinkedList<Entry<K,V>>) table[index];
        
        // 없는 값을 삭제하려고 하니까 false반환
        if (row == null) return null;
        if (!row.contains(dummy)){
            return null;
        }

        Entry<K, V> prevEntry = row.get(row.indexOf(dummy));
        row.remove(row.indexOf(dummy));
        entrySet.remove(dummy);
        if (row.isEmpty()){
            table[index] = null;
        }
        size--;
        return prevEntry.getValue(); // 노드 끝까지 찾아도 값이 없음
    }

    public _HashSet_P3<Entry<K, V>> entrySet(){
        return this.entrySet;
    }
}

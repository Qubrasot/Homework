package HW9.exercise95;

import HW9.exercise92.MyLinkedList;

import java.util.Objects;
import java.util.Arrays;

public class MyHashMap<K,V> {
    static final int MIN_INITIAL_CAPACITY = 16;
    static final int MAX_CAPACITY = 1 << 30;

    private int size;
    private Node<K,V>[] table;

    MyHashMap() {
        table = new Node[MIN_INITIAL_CAPACITY];
        size = MIN_INITIAL_CAPACITY;
    }

    private void grow(int index) {
        table = Arrays.copyOf(table, index + 1);
    }

    static class Node<K,V>{
        Node<K,V> next;
        final int hash;
        final K key;
        V value;

        Node(Node<K,V> next, int hash, K key, V value) {
            this.next = next;
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public final K getKey() {return key;}
        public final V getValue(){return value;}

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

    }

    public boolean put(K key, V value){
        Node<K,V> e = new Node<>(null, key.hashCode(), key, value);
        int index = (key.hashCode() >> 1) % size;

        if(index == size){
            grow(index);
        }

        if(table[index] == null){
            table[index] = e;
            return true;
        }

        if(table[index] != null) {
            if(table[index].getKey().equals(key)) {
                table[index].setValue(value);
                return true;
            } else{
                Node<K,V> node = table[index];
                node.next = e;
            }
        }

        return false;
    }

    public boolean remove(K key){
        int index = (key.hashCode() >> 1) % size;
        if(table[index].getKey().equals(key)) {
            table[index] = table[index].next;
        }
        return true;
    }

    public boolean clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        return true;
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < table.length; i++) {
            if(table[i] != null){
                size++;
            }
        }
        return size;
    }

    public V get(Object key){
        Node<K,V> e;
        int index = (key.hashCode() >> 1) % size;
        if(table[index].getKey().equals(key)){
            return table[index].getValue();
        } else if(table[index].next != null){
            e = table[index].next;
            return e.getKey().equals(key)? e.getValue() : null;
        }
        return null;
    }
}
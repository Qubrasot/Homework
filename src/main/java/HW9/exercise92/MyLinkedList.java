package HW9.exercise92;

import java.util.LinkedList;

public class MyLinkedList<T> {
    Node<T> first;
    Node<T> last;

    private int size = 0;

    private static class Node<T> {
        T item;

        Node<T> next;
        Node<T> prev;

        Node(T item, Node<T> next, Node<T> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    Node<T> node(int index) {

        if (index < (size >> 1)) {
            Node<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    private void linkFirst(T i) {
        final Node<T> f = first;
        final Node<T> newNode = new Node<>(i, f, null);
        first = newNode;
        if(f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    private void linkLast(T i) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<>(i, null, l);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    T unlink(Node<T> x) {
        final T element = x.item;
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    public MyLinkedList() {}

    public boolean add(T value) {
        linkLast(value);
        return true;
    }

    public boolean remove(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + " out of bounds");
        }
        unlink(node(index));
        return true;
    }

    public void clear() {
        for (Node<T> x = first; x != null; ) {
            Node<T> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + " out of bounds");
        }
        return node(index).item;
    }
}

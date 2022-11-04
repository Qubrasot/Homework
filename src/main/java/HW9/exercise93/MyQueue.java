package HW9.exercise93;

import java.util.*;

public class MyQueue<T> {
    private static final int MIN_CAPACITY = 10;
    private Object[] array;

    public MyQueue() {
        array = new Object[MIN_CAPACITY];
    }

    public MyQueue(int capacity) {
        array = new Object[capacity];
    }

    private void replaceObjects(int index) {
        for(int i = index + 1; i < array.length; i++) {
            array[i-1] = array[i];
        }
    }

    private Object[] grow(int capacity) {
        return array = Arrays.copyOf(array, capacity);
    }

    public boolean add(Object value) {
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if(array[i] != null) {
                count++;
            }
        }
        grow(count + 1);

        for (int i = 0; i < array.length; i++) {
            if(array[i] == null){
                array[i] = value;
                return true;
            }
        }
        return false;
    }

    public void remove(int index) {
        array[index] = null;
        replaceObjects(index);
    }

    public void clear() {
        for (Object values : array) {
            values = null;
        }
    }

    public int size() {
        int countOfObjects = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != null){
                countOfObjects++;
            }
        }

        return countOfObjects;
    }

    public Object peek() {
        return array[0];
    }

    public Object poll() {
        Object result = array[0];
        remove(0);
        return result;
    }
}

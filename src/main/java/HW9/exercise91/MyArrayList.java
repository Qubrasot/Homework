package HW9.exercise91;

import java.util.*;

public class MyArrayList<T>{
    private static final int DEFAULT_CAPACITY = 10;
    private Object [] elementData;

    public MyArrayList() {
        elementData =  new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if(initialCapacity >= 0) {
            elementData = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity");
        }
    }

    public int size() {
        return elementData.length;
    }

    public boolean add(Object value) {
        int count = 0;

        for (int i = 0; i < elementData.length; i++) {
            if(elementData != null) {
                count++;
            }
        }
        grow(count + 1);
        for(int i = 0; i < elementData.length; i++) {
            if(elementData[i] == null){
                elementData[i] = value;
                return true;
            }
        }
        return false;
    }

    public void remove(int index) {
        try {
            elementData[index] = null;
        }
        catch(Exception ArrayIndexOutOfBoundsException) {
            System.out.println("Index out of bounds");
        }
    }

    public void clear() {
        for (int i = 0; i < elementData.length; i++) {
            elementData[i] = null;
        }
    }

    public Object get(int index) {
        try{
            return elementData[index];
        }
        catch (Exception ArrayIndexOutOfBoundsException) {
            System.out.println("Index out of bounds");
        }
        return "error";
    }

    private Object[] grow(int minCapacity) {
        return elementData = Arrays.copyOf(elementData, minCapacity);
    }
}

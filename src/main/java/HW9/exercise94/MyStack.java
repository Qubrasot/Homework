package HW9.exercise94;

import java.util.Arrays;

public class MyStack<T> {
    private Object[] array;

    public MyStack(){
        array = new Object[10];
    }

    private void replaceObjects(int index){
        for(int i = index + 1; i < array.length; i++) {
            array[i-1] = array[i];
        }
    }

    private void grow(int capacity) {
        array = Arrays.copyOf(array, capacity + 1);
    }

    public boolean push(Object value){

        if(size() == (Object)array.length){
            grow((int)size() + 1);
        }

        for (int i = 0; i < array.length; i++) {
            if(array[i] == null) {
                array[i] = value;
                return true;
            }
        }

        return false;
    }

    public void remove(int index) {
        array[index] = null;
    }

    public void clear(){
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    public Object size(){
        Integer countOfObjects = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != null){
                countOfObjects++;
            }
        }

        if(countOfObjects == 0){
            return "Stack is empty";
        }
        return "Size is = " + countOfObjects;
    }

    public Object peek(){
        for(int i = array.length - 1; i >= 0; i--) {
            if(array[i] != null){
                return array[i];
            }
        }

        return null;
    }

    public Object pop(){
        Object result = peek();
        for(int i = array.length - 1; i >= 0; i--) {
            if(array[i] != null){
                 remove(i);
                 return result;
            }
        }
        return "Stack is empty";
    }
}

package HW9.exercise92;

import java.util.LinkedList;
import java.util.List;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList();

        //add & get test
        list.add("Java");
        list.add("Something");

        System.out.println(list.get(0));
        System.out.println(list.get(1));

        // remove test
        list.remove(0);
        System.out.println(list.get(0));

        // size & clear test
        System.out.println(list.size());

        list.clear();

        System.out.println(list.size());
    }
}

package HW9.exercise91;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList <String> list = new MyArrayList <>();

        //add and get test
        list.add("A");
        list.add("B");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("k");
        list.add("l");
        list.add("m");
        list.add("a");
        System.out.println(list.get(10));
        System.out.println(list.get(9));
        System.out.println(list.get(8));

        // remove test
        list.remove(9);
        System.out.println(list.get(9));

        // clear test
        list.clear();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // size test
        System.out.println(list.size());

        // out of bounds test
        System.out.println(list.get(10));
    }
}

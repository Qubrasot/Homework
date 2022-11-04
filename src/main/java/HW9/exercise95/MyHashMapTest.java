package HW9.exercise95;



public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap <String, Integer> map = new MyHashMap<>();
        map.put("Java", 100);

        System.out.println(map.get("Java"));

        map.put("Java", 150);
        map.put("Kotlin", 50);

        System.out.println(map.get("Java"));
        System.out.println(map.get("Kotlin"));

        map.clear();
        System.out.println(map.size());

        map.remove("Kotlin");
        System.out.println(map.get("Kotlin"));

        System.out.println(map.size());

    }
}

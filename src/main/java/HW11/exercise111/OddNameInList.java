package HW11.exercise111;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OddNameInList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1. John");
        list.add("2. Mike");
        list.add("3. John");
        list.add("4. Mike");
        list.add("5. John");
        list.add("6. Mike");

        System.out.println(findOddNames(list));
    }

    public static String findOddNames(List<String> names){
        return names.stream()
                .collect(Collectors.joining(", "));
    }
}

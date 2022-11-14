package HW11.exercise112;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListUpperCaseSorted {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("smt");
        list.add("cba");
        list.add("abc");
        list.add("xyz");
        System.out.println(toUpperSorted(list));
    }

    public static List<String> toUpperSorted(List<String> list){
        return list.stream()
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
    }
}

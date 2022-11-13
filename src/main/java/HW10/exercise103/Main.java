package HW10.exercise103;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("HW10-materials/words.txt"));
        Map<String, Integer> result = new HashMap<>();

        String s = "";
        while((s = br.readLine()) != null) {

            String[] array = s.split(" ");

            for (int i = 0; i < array.length; i++) {
                String word = array[i];
                if (!result.containsKey(word)) {
                    result.put(word, 1);
                } else {
                    Integer currentCount = result.get(word);
                    result.put(word, currentCount + 1);
                }

            }
        }
        br.close();
        System.out.println(result);

        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return result.get(o1) < result.get(o2) ? 1 : -1;
            }
        };

        Map<String, Integer> treeMap = new TreeMap<>(comparator);
        treeMap.putAll(result);
       // System.out.println(treeMap);
    }
}

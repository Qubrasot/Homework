package HW10.exercise103;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("HW10-materials/words.txt");
        Map<String, Integer> result = new HashMap<>();

        int c;
        byte [] buf = new byte[256];
        while((c = fis.read(buf)) > 0){
            if(c < 256){
                buf = Arrays.copyOf(buf, c);
            }
        }
        String s = new String(buf, "UTF-8");
        fis.close();

        String[] array = s.split("\r\n");

        for (int i = 0; i < array.length; i++) {
            String[] array1 = array[i].split(" ");
            for (int j = 0; j < array1.length; j++) {
                String word = array1[j];
                if(!result.containsKey(word)){
                    result.put(word, 1);
                } else {
                    Integer currentCount = result.get(word);
                    result.put(word, currentCount + 1);
                }
            }
        }
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

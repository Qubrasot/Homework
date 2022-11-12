package HW10.exercise103;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("HW10-materials/words.txt");
        Scanner scanner = new Scanner(fis);
        Map<String, Integer> result = new HashMap<>();
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            String [] array = line.split(" ");

            for (int i = 0; i < array.length; i++) {
                String word = array[i];
                if(!result.containsKey(word)){
                    result.put(word, 1);
                } else {
                    result.put(word, result.get(word) + 1);
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
    }
}

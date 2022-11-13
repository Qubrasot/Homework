package HW11.exercise111;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("HW10-materials/words.txt"));
        String line = br.readLine();
        System.out.println(line);
    }
}

package HW10.exercise101;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;
import java.util.*;

public class PhoneNumberFinder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("HW10-materials/filePhone.txt"));


        String pattern1 = "^\\d{3}-\\d{3}-\\d{4}$";
        String pattern2 = "^\\(\\d{3}\\)\\s\\d{3}-\\d{4}$";

        Pattern phonePattern1 = Pattern.compile(pattern1);
        Pattern phonePattern2 = Pattern.compile(pattern2);

        String s = "";
        while((s = br.readLine()) != null) {

            Matcher match1 = phonePattern1.matcher(s);
            Matcher match2 = phonePattern2.matcher(s);

            if (match1.matches() || match2.matches()) {
                System.out.println(s);
            }
        }

        br.close();
    }
}

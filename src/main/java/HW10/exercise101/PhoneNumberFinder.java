package HW10.exercise101;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.*;
import java.util.*;

public class PhoneNumberFinder {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("HW10-materials/filePhone.txt");

        int c;
        byte [] buf = new byte[256];
        while((c = fis.read(buf)) > 0){
            if(c < 256){
                buf = Arrays.copyOf(buf, c);
            }
        }

        String pattern1 = "^\\d{3}-\\d{3}-\\d{4}$";
        String pattern2 = "^\\(\\d{3}\\)\\s\\d{3}-\\d{4}$";

        Pattern phonePattern1 = Pattern.compile(pattern1);
        Pattern phonePattern2 = Pattern.compile(pattern2);


        String s = new String(buf, "UTF-8");
        String[] array = s.split("\r\n");
        String str = "";

        for (int i = 0; i < array.length; i++) {

            Matcher match1 = phonePattern1.matcher(array[i]);
            Matcher match2 = phonePattern2.matcher(array[i]);

            if (match1.matches() || match2.matches()) {
                str = array[i] + "\n";
            } else{
                str = "";
            }

            System.out.print(str);
        }


        fis.close();
    }
}

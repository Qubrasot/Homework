package HW10.exercise101;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.regex.*;
import java.util.*;

public class PhoneNumberFinder {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("file.txt");
        Scanner scanner = new Scanner(fis);

        String pattern1 = "\\d{3}-\\d{3}-\\d{4}";
        String pattern2 = "\\(\\d{3}\\)\\s\\d{3}-\\d{4}";

        Pattern phonePattern1 = Pattern.compile(pattern1);
        Pattern phonePattern2 = Pattern.compile(pattern2);


        while(scanner.hasNext()) {
            String s = scanner.nextLine();
            String str = "";

            Matcher match1 = phonePattern1.matcher(s);
            Matcher match2 = phonePattern2.matcher(s);

            if(match1.matches() || match2.matches()) {
                str = s + "\n";
            }

            System.out.print(str);
        }
    }
}

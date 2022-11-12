package HW10.exercise102;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TxtToJSON {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("HW10-materials/fileUser.txt");
        Scanner scanner = new Scanner(fis);
        String [] dataArray;
        scanner.nextLine();

        dataArray = scanner.nextLine().split(" ");
        UserDto userDto1 = new UserDto();
        userDto1.setName(dataArray[0]);
        userDto1.setAge(Integer.parseInt(dataArray[1]));

        dataArray = scanner.nextLine().split(" ");
        UserDto userDto2 = new UserDto();
        userDto2.setName(dataArray[0]);
        userDto2.setAge(Integer.parseInt(dataArray[1]));

        UserDto [] userArray = {userDto1, userDto2};


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(userArray);
        FileOutputStream fos = new FileOutputStream("HW10-materials/user.json");
        fos.write(s.getBytes());

        fis.close();
        fos.flush();
        fos.close();
    }
}

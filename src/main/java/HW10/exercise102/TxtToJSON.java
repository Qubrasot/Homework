package HW10.exercise102;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Arrays;

public class TxtToJSON {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("HW10-materials/fileUser.txt"));
        br.readLine();

        String[] dataArray;

        dataArray = br.readLine().split(" ");
        UserDto userDto1 = new UserDto();
        userDto1.setName(dataArray[0]);
        userDto1.setAge(Integer.parseInt(dataArray[1]));

        dataArray = br.readLine().split(" ");
        UserDto userDto2 = new UserDto();
        userDto2.setName(dataArray[0]);
        userDto2.setAge(Integer.parseInt(dataArray[1]));


        UserDto[] userArray = {userDto1, userDto2};

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String str = gson.toJson(userArray);
        FileOutputStream fos = new FileOutputStream("HW10-materials/user.json");
        fos.write(str.getBytes());

        fos.flush();
        fos.close();
        br.close();
    }
}

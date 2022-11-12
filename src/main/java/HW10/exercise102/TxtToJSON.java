package HW10.exercise102;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class TxtToJSON {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("HW10-materials/fileUser.txt");
        int c;
        byte [] buf = new byte[256];
        while((c = fis.read(buf)) > 0){
            if(c < 256){
                buf = Arrays.copyOf(buf, c);
            }
        }
        String s = new String(buf);
        String [] dataArray = s.split(" ");

        UserDto userDto1 = new UserDto();
        userDto1.setName(dataArray[2]);
        userDto1.setAge(Integer.parseInt(dataArray[3]));

        UserDto userDto2 = new UserDto();
        userDto2.setName(dataArray[4]);
        userDto2.setAge(Integer.parseInt(dataArray[5]));

        UserDto [] userArray = {userDto1, userDto2};


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String str = gson.toJson(userArray);
        FileOutputStream fos = new FileOutputStream("HW10-materials/user.json");
        fos.write(str.getBytes());

        fis.close();
        fos.flush();
        fos.close();
    }
}

package com.epam.mjc.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;


public class FileReader {

//    File profile = new File("C:\\Users\\Prime_Z370\\IdeaProjects\\stage0-module3-task4\\stage1-module6-io-task1\\src\\main\\resources\\Profile.txt");

    public Profile getDataFromFile(File file) {

        StringBuilder data = new StringBuilder();
        FileInputStream inputStream = null;
        Map<String,String> map = new HashMap<>();
        try {
        inputStream = new FileInputStream("C:\\Users\\Prime_Z370\\IdeaProjects\\stage0-module3-task4\\stage1-module6-io-task1\\src\\main\\resources\\Profile.txt");
/*        } catch (FileNotFoundException e) {
            e.printStackTrace();*/
        int ch;
        while ((ch=inputStream.read()) != -1) {
            data.append((char) ch);
        }
        String[] keyPairs = data.toString().split("\n");
            for (String pair:keyPairs) {
                String[] keyValue = pair.split(": ");
                map.put(keyValue[0],keyValue[1].trim());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new Profile(map.get("Name"),
                parseInt(map.get("Age")),
                map.get("Email"),
                Long.parseLong(map.get("Phone")));
    }
}

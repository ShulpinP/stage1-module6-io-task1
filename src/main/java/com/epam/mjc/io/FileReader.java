package com.epam.mjc.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;


public class FileReader {
        public Profile getDataFromFile(File file) {

        StringBuilder data = new StringBuilder();
        Map<String,String> map = new HashMap<>();
        int ch;
        try (FileInputStream inputStream = new FileInputStream(file)) {
            while ((ch = inputStream.read()) != -1) {
                data.append((char) ch);
            }
            String[] keyPairs = data.toString().split("\n");
            for (String pair : keyPairs) {
                String[] keyValue = pair.split(": ");
                map.put(keyValue[0], keyValue[1].trim());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return new Profile(map.get("Name"),
                parseInt(map.get("Age")),
                map.get("Email"),
                Long.parseLong(map.get("Phone")));
    }
}

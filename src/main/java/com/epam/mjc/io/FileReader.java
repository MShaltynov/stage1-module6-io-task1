package com.epam.mjc.io;

import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile=null;
        StringBuilder stringBuilder = new StringBuilder();
        try (java.io.FileReader fileReader = new java.io.FileReader(file);) {
            int symbol;
            String name = null;
            Integer age = null;
            String email = null;
            Long phone = null;
            while ((symbol = fileReader.read()) != -1) {
                stringBuilder.append(String.valueOf((char) symbol));
            }
            String[] splitText = stringBuilder.toString().split("\n");
            for (int i = 0; i < splitText.length; i++) {
                if (splitText[i].contains("Name")) {
                    name = splitText[i].replace("Name: ", "");
                } else if (splitText[i].contains("Age")) {
                    age = Integer.valueOf(splitText[i].replace("Age: ", ""));
                } else if (splitText[i].contains("Email")) {
                    email = splitText[i].replace("Email: ", "");
                } else if (splitText[i].contains("Phone")) {
                    phone = Long.valueOf(splitText[i].replace("Phone: ", ""));
                }
            }
            profile = new Profile(name, age, email, phone);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return profile;
    }
}

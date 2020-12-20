package org.example.contentmanager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContentManager {

    public static List<String> getContent(String fileName){
        String fileContent = "";
        List<String> content = null;

        try {
            fileContent = new String(Files.readAllBytes(Paths.get(fileName)));
            fileContent = fileContent.replaceAll("\\s", " ");
            content = Arrays.asList(fileContent.split(" "));
            return content;
        }catch (IOException exception){
            System.out.println("\nNo Such File: " + fileName);
            return content;
        }
    }
}

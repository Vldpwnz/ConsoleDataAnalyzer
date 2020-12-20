package org.example.counter;

import org.example.argscontroller.ArgsController;
import org.example.contentmanager.ContentManager;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Counter {

    private ArgsController argsController;


    public Counter(ArgsController argsController) {
        this.argsController = argsController;
    }

    public Counter() {
    }

    public int countWords(List<String> fileContent, String... stopWords){
        List<String> stopWordsList = Arrays.asList(stopWords).stream()
                .map(w -> w.toLowerCase())
                .collect(Collectors.toList());

        fileContent = fileContent.stream()
                .map(s -> s.replaceAll("\\W", ""))
                .filter(s -> s.matches(".*[a-zA-Z]+.*") && !stopWordsList.contains(s.toLowerCase()))
                .collect(Collectors.toList());

        return fileContent.size();
    }

    public int countCharacters(List<String> fileContent){
        int charactersQuantity = 0;

        for (String fileElement: fileContent) {
            charactersQuantity += fileElement.length();
        }
        return charactersQuantity ;
    }

    public int countCapsLettersWords(List<String> fileContent){

        fileContent = fileContent.stream()
                .map(s -> s.replaceAll("\\W", ""))
                .filter(s -> s.matches("[A-Z]\\S+"))
                .collect(Collectors.toList());

        return fileContent.size();
    }

    public void runCounter(){

        int totalWords = 0;
        int totalCharacters = 0;
        int totalWordsWithFirstCapital = 0;

        try {
            for (String filePath : argsController.getFileNames()) {
                if (ContentManager.getContent(filePath).size() == 0) {
                    continue;
                }
                List<String> textContent = ContentManager.getContent(filePath);
                System.out.println("\n" + filePath);


                int words = countWords(textContent, argsController.getAvoidedWords());
                System.out.println("Words: " + words);
                totalWords += words;

                if (argsController.isCountCharacters()) {
                    int characters = countCharacters(textContent);
                    System.out.println("Characters: " + characters);
                    totalCharacters += characters;

                }
                if (argsController.isStartFromCapitalLetter()) {
                    int wordsWithFirstCapital = countCapsLettersWords(textContent);
                    System.out.println("Words started with capital letter: " + wordsWithFirstCapital);
                    totalWordsWithFirstCapital += wordsWithFirstCapital;
                }
            }
        }catch (NullPointerException exception){
            return;
        }
        System.out.println("\nTOTAL");
        System.out.printf("%S: %d %n", "Words", totalWords );
        if(argsController.isCountCharacters()){
            System.out.printf("%S: %d %n", "Characters", totalCharacters );
        }
        if(argsController.isStartFromCapitalLetter()){
            System.out.printf("%S: %d %n", "Words started with capital letter", totalWordsWithFirstCapital);
        }
    }
}


package org.example.counter;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CounterTest {

    private Counter counter = new Counter();

    private List<String> fakeFileContent = new ArrayList<>(Arrays
            .asList("word1", "word2", "111", "222", "6,12-mile-long", "she-wolf", "Word3", "Word4"));

    @Test
    public void testIfWordsWithoutStopWordsAreCountedRight(){

        int expectedQuantityOfWords = 5;
        int actualQuantityOfWords  = counter.countWords(fakeFileContent, "Word3");

        assertEquals(expectedQuantityOfWords, actualQuantityOfWords);
    }

    @Test
    public void testIfWordsAreCountedRight(){

        int expectedQuantityOfWords = 6;
        int actualQuantityOfWords  = counter.countWords(fakeFileContent);

        assertEquals(expectedQuantityOfWords, actualQuantityOfWords);
    }

    @Test
    public void testIfCharactersAreCountedRight(){

        int expectedQuantityOfWords = 48;
        int actualQuantityOfWords  = counter.countCharacters(fakeFileContent);

        assertEquals(expectedQuantityOfWords, actualQuantityOfWords);
    }

    @Test
    public void testIfWordsWithCapitalsAreCountedRight(){

        int expectedQuantityOfWords = 2;
        int actualQuantityOfWords  = counter.countCapsLettersWords(fakeFileContent);

        assertEquals(expectedQuantityOfWords, actualQuantityOfWords);
    }






}
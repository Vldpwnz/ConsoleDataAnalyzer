package org.example.argscontroller;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

public class ArgsControllerTest {


    private ArgsController argsController = new ArgsController();

    @Test
    public void testIfFileArgumentIsMissing(){

        String [] arguments = {};

        Exception exception = assertThrows(ParameterException.class, () ->{
            JCommander.newBuilder().addObject(argsController).build().parse(arguments);
        });

        assertTrue(exception.getMessage().contains("The following option is required: [-F]"));

    }

    @Test
    public void testIfNonRequiredArgumentsAreMissing(){
        String [] arguments = {"-F", "src/test/resources/sample.txt"};

        JCommander.newBuilder().addObject(argsController).build().parse(arguments);

        int expectedSizeOfStopWordsArray = 0;
        int actualSizeOfStopWordsArray= argsController.getAvoidedWords().length;

        assertFalse(argsController.isCountCharacters());
        assertFalse(argsController.isStartFromCapitalLetter());
        assertEquals(expectedSizeOfStopWordsArray, actualSizeOfStopWordsArray);


    }

    @Test
    public void testIfStopWordsArgumentIsEmpty(){
        String [] arguments = {"-F", "src/test/resources/sample.txt", "-S"};

        Exception exception = assertThrows(ParameterException.class, () ->{
            JCommander.newBuilder().addObject(argsController).build().parse(arguments);
        });

        assertTrue(exception.getMessage().contains("Expected a value after parameter -S"));
    }

}
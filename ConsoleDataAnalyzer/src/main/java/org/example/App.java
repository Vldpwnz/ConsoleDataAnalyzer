package org.example;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import org.example.argscontroller.ArgsController;
import org.example.counter.Counter;


public class App{

    public static void main(String... args ){

        ArgsController app = new ArgsController();
        try {
            JCommander jCommander = JCommander.newBuilder()
                    .addObject(app)
                    .build();
            jCommander.parse(args);
        }catch (ParameterException ex){
            System.out.println(ex.getMessage());
        }
        Counter counter = new Counter(app);

        counter.runCounter();

    }
}


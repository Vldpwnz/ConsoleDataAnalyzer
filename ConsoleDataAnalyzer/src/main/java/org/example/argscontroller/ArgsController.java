package org.example.argscontroller;

import com.beust.jcommander.Parameter;

import java.util.ArrayList;
import java.util.List;

public class ArgsController {

    @Parameter(names = "-F", description = "File path", required = true, variableArity = true)
    private List<String> fileNames;

    @Parameter(names = "-C", required = false, arity = -1)
    private boolean countCharacters;

    @Parameter(names = "-S", required = false, description = "Stop words", variableArity = true)
    private List<String> avoidedWords;

    @Parameter(names = "-L", required = false, description = "Count words with Cap", arity = -1)
    private boolean startWithCapitalLetter;

    public boolean isStartWithCapitalLetter() {
        return startWithCapitalLetter;
    }

    public void setStartWithCapitalLetter(boolean startWithCapitalLetter) {
        this.startWithCapitalLetter = startWithCapitalLetter;
    }

    public String [] getAvoidedWords() {
        if(avoidedWords == null){
            setAvoidedWords(new ArrayList<>());
        }
        return avoidedWords.toArray(new String[0]);
    }

    public void setAvoidedWords(List<String> avoidedWords) {
        this.avoidedWords = avoidedWords;
    }

    public boolean isCountCharacters() {
        return countCharacters;
    }

    public void setCountCharacters(boolean countCharacters) {
        this.countCharacters = countCharacters;
    }

    public List<String> getFileNames() {
        return fileNames;
    }

    public void setFileNames(List<String> fileNames) {
        this.fileNames = fileNames;
    }
}

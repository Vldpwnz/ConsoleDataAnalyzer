# ConsoleDataAnalyzer
ConsoleDataAnalyzer App created for analyzing data from text files. 

### Functionality:
* Count number of words
* Count number of characters
* Count number of words excluding chosen words
* Count number of words that started with capital letter
* Count total number of all parameters that were entered

### Run the app:

```
$java –jar scraper.jar -F <names of files> -C -S <stop words> -L

-F <names of files> (required flag and at least one argument) should be full qulified name if file outside root directory, 
enter as much as needed files splited by space
-C (non-required) count characters in files
-S <stop words> (non-required) count all words excluding all listed stop words, should be splited by space
-L (non-required) count words started with capital letters
```

### Technologies used:

* Java for main part
* JUnit5 for testing part
* JCommander for parsing arguments from the console


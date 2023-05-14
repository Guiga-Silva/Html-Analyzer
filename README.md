# Html Analyzer

## Summary

### Html Analyzer is a Java program that analyzes an HTML page. When a URL is passed to the program, it returns the text that is contained in the largest number of tags. Additionally, the program is capable of verifying if no argument was passed in the terminal, if the HTML content was successfully obtained in case the connection was not interrupted, and if the HTML structure is malformed. If any of these verifications fail, the program will be terminated and the user will be informed of what happened.

<br>

## How to use

### Clone the repository
```
$ git clone https://github.com/Guiga-Silva/Html-Analyzer.git
```

### Compile the program
```
$ cd Html-Analyzer
$ javac HtmlAnalyzer.java
```

### Run the program
```
java HtmlAnalyzer.java <url>
```

Replace `<url>` with the URL of the HTML page you want to analyze.
package com.company.exercise6;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:/Users/marin/IdeaProjects/Java2.0/src/com/company/exercise6/words.txt";
        FileReaderWrapper fileReaderWrapper = new FileReaderWrapper(filePath);
        fileReaderWrapper.start();
    }
}

package com.company.exercise6;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class FileReaderWrapper {
    private final String filePath;

    public FileReaderWrapper(String filePath) {
        this.filePath = filePath;
    }

    public void start() {
        Map<String, Integer> wordList = new TreeMap<>();
        String sourceText = readTextFromFile(); // Исходный текст из файла

        String[] words = sourceText.split(" ");

        //Для создание статистики и поиска слов, которое встречается максимальное количество раз
        //будем использовать контейнер TreeMap, в котором ключи  хранятся в отсортированном виде,
        //в качестве ключа у нас будет слово из файла, а в качестве его значения - кол-во повторений
        //слово всегда останется уникальным, мы будем изменять только количество вхождений этого слова в файл
        for (String word : words) {
            if (!wordList.containsKey(word)) wordList.put(word, 1);
            else wordList.put(word, wordList.get(word) + 1);
        }
        System.out.println("Слово - Количество повторений");
        String key;
        String maxKey = null; // слово, которое встречается наибольшее количество раз
        int value;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : wordList.entrySet()) {
            key = entry.getKey();
            value = entry.getValue();
            if (value > maxCount) {
                maxCount = value;
                maxKey = key;
            }
            System.out.println(String.format("%s - %d", key, value));
        }
        System.out.println(String.format("Слово '%s' встречается в файле %d раз(а)", maxKey, maxCount));
    }

    private String readTextFromFile() {
        StringBuilder text = new StringBuilder();
        //  FileInputStream fin;
        try (FileReader fin = new FileReader(filePath)) {
            int c = fin.read();
            while (c != -1) {//пока не конец файла
                text.append((char) c);
                c = fin.read();
            }
            // text.append(buf);
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

}

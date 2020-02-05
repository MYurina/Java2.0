package com.company.exercise3;

import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class Search {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите длину массива:");
        int size = in.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
        String array[] = new String[size];
        System.out.println("Введите слова в количестве, равном заданной длине массива");
        for (int i = 0; i < size; i++) {
            array[i] = in.next();// Заполняем массив элементами, введёнными с клавиатуры
        }
        String max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].length() > array[i - 1].length()) {
                max = array[i];
            }
        }
        System.out.println("Самое длинное слово в массиве: " + max);
    }
}
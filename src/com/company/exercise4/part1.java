package com.company.exercise4;

public class part1 {
    public static void main(String[] args) {
        int[] array = new int[20];
        System.out.println("Элементы массива в диапозоне от -10 до 10:");
        for (int i = 0; i < 20; i++) {
            array[i] = (int) Math.round((Math.random() * 20) - 10);// генерация чисел от -10 до 10
            System.out.print(array[i] + " ");//Вывод массива в одну строку
        }
        int maxNegativeNumber = array[0];
        int minPositiveNumber = array[0];
        int maxNegativeNumberIndex = 0;
        int minPositiveNumberIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                minPositiveNumber = array[i];
                minPositiveNumberIndex = i;
                break;
            }
        }
        for (int i = 1; i < array.length; i++) {
            if (maxNegativeNumber > array[i] && array[i] < 0) {
                maxNegativeNumber = array[i];
                maxNegativeNumberIndex = i;
            }
            if (minPositiveNumber > array[i] && array[i] >= 0) {
                minPositiveNumber = array[i];
                minPositiveNumberIndex = i;
            }
        }

        System.out.println('\n' + "Максимальное отрицательное число в массиве:" + maxNegativeNumber + '\n' +
                "Минимальное положительное число в массиве:" + minPositiveNumber + '\n' + "Меняем местами полученные числа:");

        array[maxNegativeNumberIndex] = minPositiveNumber;
        array[minPositiveNumberIndex] = maxNegativeNumber;
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}

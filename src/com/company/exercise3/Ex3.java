package com.company.exercise3;

import com.company.Ex2;

import java.util.Scanner;

public class Ex3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Выберите номер" + "\n" + "1 - калькулятор" + "\n" + "2 - Поиск саммого длинного слова в массиве");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                Ex2.main(args);
                break;
            case 2:
                Search.main(args);
                break;
            default:
        }


    }
}

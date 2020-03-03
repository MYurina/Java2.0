package com.company.exercise4.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        prepareGift();
    }

    public static void prepareGift() throws IOException {
        ArrayList<Sweets> sweets = new ArrayList<>();
        boolean formed = false;
        int totalPrice = 0;
        int totalWeight = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nСоберём новогодний подарок, выберите цифру сладостей, чтобы добавить их в корзину.\nНажмите цифру 4 по заверщению выбора, чтобы перейти к подсчёту стоимости и веса новогоднего подарка:");
        System.out.println("'1' - конфеты \"Мишка на севере\"");
        System.out.println("'2' - конфеты \"Алёнка\"");
        System.out.println("'3' - желейные бобы \"Фруктовое ассорти\"");
        System.out.println("'4' - закончить выбор");
        while (!formed) {

            String choice = reader.readLine();

            switch (choice) {
                case "1":
                    Candy candyM = new Candy("Конфеты \"Мишка на севере\"", 250, 1000, "С вафлей внутри");
                    sweets.add(candyM);
                    totalPrice += candyM.getPrice();
                    totalWeight += candyM.getWeight();
                    System.out.println("Конфеты \"Мишка на севере\" добавлены в подарок");
                    break;
                case "2":
                    Candy candyA = new Candy("Конфеты \"Алёнка\"", 119, 150, "Без пальмового масла");
                    sweets.add(candyA);
                    totalPrice += candyA.getPrice();
                    totalWeight += candyA.getWeight();
                    System.out.println("Конфеты \"Алёнка\" добавлены в подарок");
                    break;
                case "3":
                    Jellybean frut = new Jellybean("Желейные бобы \"Фруктовое ассорти\"", 100, 100, "Больше с апельсиновым вкусом");
                    sweets.add(frut);
                    totalPrice += frut.getPrice();
                    totalWeight += frut.getWeight();
                    System.out.println("Желейные бобы  \"Фруктовое ассорти\" добавлены в подарок");
                    break;
                case "4":
                    formed = true;
                    break;
            }


        }
        int count = 0;
        System.out.println("\nПодарок состоит из:");
        for (Sweets sweet : sweets) {
            count++;
            System.out.println(count + ". " + sweet.getName() + " - " + sweet.getAdditionalInformation());
        }
        System.out.println(String.format("\nОбщий вес подарка составляет: %s гр.\nОбщая цена подарка составляет: %s руб.", totalWeight, totalPrice));
    }

}

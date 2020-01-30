package com.company;

import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {
        double result = 0;

        Scanner in = new Scanner(System.in);//Инициализация объекта in класса Scanner
        System.out.println("Введите первое число: ");
        double x = in.nextDouble();//Чтение типа числа double с консоля
        System.out.println("Введите второе число: ");
        double y = in.nextDouble();
        System.out.println("Выберите и введите номер арифметического действия: ");
        System.out.println("сумма - 1" + "\n"
                + "разность - 2" + "\n"
                + "деление - 3" + "\n"
                + "умножение - 4");
            int action = in.nextInt();
            switch (action) { //Использование оператора switch
                case 1:
                    result = x + y;
                    break;
                case 2:
                    result = x - y;
                    break;
                case 3:
                    result = x / y;
                    break;
                case 4:
                    result = x * y;
                    break;
                default:
                    System.out.println(" ");
            }
            if (result != 0) {
                result = Math.round(result * 10000) / 10000.0d;//Округление до четырёх знаков после запятой
                System.out.println("Ответ :" + result + "\n");
            }
        in.close();
    }

}
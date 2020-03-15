package com.company.calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите выражение");
        String expression = in.nextLine();
        ValidationOfInputExpression validation = new ValidationOfInputExpression();
        validation.startValidation(expression);
    }
}

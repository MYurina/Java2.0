package com.company.calculator;

import java.util.Scanner;

class ValidationOfInputExpression {
    private String error = "";

    void startValidation(String expression) {
        if (validation(expression)) {
            Calculator calculator = new Calculator(expression);
            try {
                double result = calculator.startCalculator();
                System.out.print("Результат: " + result + "\n");
            } catch (ArithmeticException e) {
                error = "Делить на ноль нельзя";
                System.out.print(error);
            }
        } else {
            error = "Выражение введено неверно";
            System.out.print(error);
        }
    }

    private boolean validation(String expression) {
        //регулярное выражение: [] - которое в кфадратных скобках
        // 0-9- в выражениее должны встречаться числа от 0 до 9
        // "\\-" поиск символа "-"
        // после [] квантификатор "+" означает - появление один и более раза
        String regex = "[0-9+\\-=*/,.()]+";
        return expression.matches(regex);
    }
    public String getError() {
        return error;
    }
}

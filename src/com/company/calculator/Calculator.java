package com.company.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private String expression;
    private double result = 0;

    public Calculator(String expression) {
        this.expression = expression;
    }
    public void startCalculator() {
        if (checkExpression(expression)) {
            result = calculate();
            System.out.print("Результат: " + result + "\n");
        } else {
            System.err.println("Выражение введено неверно");
            System.exit(0);
        }
    }

    private double calculate() {
        List<String> list = new ArrayList<>();
        //Преобразуем введенное выражение. Разделяем числа и знаки пробелами.
        //Для последующего легкого разделения на числа и знаки
        conversionOfExpression();

        //Разбиваем выражение на числа и знаки
        String[] finalExpression = expression.split(" ");
        //Формируем упорядоченный массив, какждый элемент которого либо число либо знак
        for (String element : finalExpression) {
            if (!element.equals("")) list.add(element);
        }
        List<String> secondExpression = new ArrayList<>();

        while (true) {
            int startPoint;
            int endPoint = 0;
            if (list.contains("(")) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).equals("(")) {
                        startPoint = i;
                        //Записываем в вспомогательный список выражение в скобках
                        for (int j = i + 1; j < list.size(); j++) {
                            if (!list.get(j).equals(")")) {
                                secondExpression.add(list.get(j));
                            } else if (list.get(j).equals(")")) {
                                endPoint = j;
                                operations(secondExpression);
                                break;
                            }
                        }
                        //После выполнения предыдущего цикла, у нас в secondExpression посчитанный результат,
                        //теперь нам нужно удалить из главного списка числа и знак, с которыми производилась работа
                        //и заменить их на полученный результат
                        //Удаляем из списка выражение в скобках
                        for (int k = endPoint; k < list.size(); k--) {
                            if (k >= startPoint) {
                                list.remove(k);
                                if (k == startPoint) break;
                            }
                        }
                        //Добавляем в скобки результат вычисления
                        list.add(i, String.valueOf(result));
                    }
                }
                //operations(list);
            }
            operations(list);
            break;
        }
        return result;
    }


    private void conversionOfExpression() {
        //Проверяем, если выражение написано слитно, то разделяем числа от знака пробелом.
        if (expression.contains("+")) expression = expression.replace("+", " + ");
        if (expression.contains("-")) expression = expression.replace("-", " - ");
        if (expression.contains("*")) expression = expression.replace("*", " * ");
        if (expression.contains("/")) expression = expression.replace("/", " / ");
        if (expression.contains("(")) expression = expression.replace("(", " ( ");
        if (expression.contains(")")) expression = expression.replace(")", " ) ");
        //Замена запятой на точку, если таковая есть в выражении
        if (expression.contains(",")) expression = expression.replace(",", ".");
    }

    private void operations(List<String> subExpression) {
        while (true) {
            if (subExpression.contains("*") || subExpression.contains("/") || subExpression.contains("+") || subExpression.contains("-")) {
                for (int i = 0; i < subExpression.size(); i++) {
                    switch (subExpression.get(i)) {
                        case "*":
                            result = Double.parseDouble(subExpression.get(i - 1)) * Double.parseDouble(subExpression.get(i + 1));
                            substitution(subExpression, i);
                            break;
                        case "/":
                            //Обработка ошибки
                           try {
                                double denominator = Double.parseDouble(subExpression.get(i + 1)); //знаменатель
                                if (denominator == 0) {
                                    throw new ArithmeticException();
                                } else {
                                    //int h = 7/0;
;                                    result = Double.parseDouble(subExpression.get(i - 1)) / denominator;
                                    substitution(subExpression, i);
                                }
                           } catch (ArithmeticException e) {
                              System.err.println("На ноль делить нельзя");
                                System.exit(0);
                            }
                            break;
                        case "+":
                            result = Double.parseDouble(subExpression.get(i - 1)) + Double.parseDouble(subExpression.get(i + 1));
                            substitution(subExpression, i);
                            break;
                        case "-":
                            result = Double.parseDouble(subExpression.get(i - 1)) - Double.parseDouble(subExpression.get(i + 1));
                            substitution(subExpression, i);
                            break;
                    }
                }
            } else {
                break;
            }
        }
    }

    //Замена выражение на получившееся значение
    // к примеру было 1+3 стало 4
    private void substitution(List<String> list, int i) {
        list.remove(i + 1);
        list.remove(i);
        list.remove(i - 1);
        list.add(i - 1, String.valueOf(result));
    }

    private boolean checkExpression(String expression) {
        //регулярное выражение: [] - которое в кфадратных скобках
        // 0-9- в выражениее должны встречаться числа от 0 до 9
        // "\\-" поиск символа "-"
        // после [] квантификатор "+" означает - появление один и более раза
        String regex = "[0-9+\\-=*/,.()]+";
        return expression.matches(regex);
    }

    public double getResult() {
        return result;
    }
}
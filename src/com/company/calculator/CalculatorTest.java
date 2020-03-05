package com.company.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    //Проверка сложение
    @Test
    public void startCalculatorAddition() {
        //arrange - подготовка
        String expression = "(2+3)";
        Calculator calculator = new Calculator(expression);
        double expectedResult = 5.0;
        //act
        calculator.startCalculator();
        //assert
        Assert.assertEquals(calculator.getResult(),expectedResult, 0.00001);
    }

    //Проверка вычитания
    @Test
    public void startCalculatorSubstraction() {
        //arrange - подготовка
        String expression = "(10-77)";
        Calculator calculator = new Calculator(expression);
        double expectedResult = -67.0;
        //act
        calculator.startCalculator();
        //assert
        Assert.assertEquals(expectedResult, calculator.getResult(), 0);
    }

    //Проверка умножение
    @Test
    public void startCalculatorMultiplication() {
        //arrange - подготовка
        String expression = "(78*967)";
        Calculator calculator = new Calculator(expression);
        double expectedResult = 75426.0;
        //act
        calculator.startCalculator();
        //assert
        Assert.assertEquals(expectedResult, calculator.getResult(), 0);
    }

    //Проверка деления
    @Test
    public void startCalculatorDivision() {
        //arrange - подготовка
        String expression = "(78/967)";
        Calculator calculator = new Calculator(expression);
        double expectedResult = 0.0806618407;
        //act
        calculator.startCalculator();
        //assert
        Assert.assertEquals(expectedResult, calculator.getResult(), 0.0000001);
    }

    //Проверка сложного запроса
    @Test
    public void startCalculatorComplexRequest() {
        //arrange - подготовка
        String expression = "(9/3)+2+10/2-2*3";
        Calculator calculator = new Calculator(expression);
        double expectedResult = 4;
        //act
        calculator.startCalculator();
        //assert
        Assert.assertEquals(expectedResult, calculator.getResult(), 0);
    }
}
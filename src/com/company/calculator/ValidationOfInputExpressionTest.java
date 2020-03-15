package com.company.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ValidationOfInputExpressionTest {
    private ValidationOfInputExpression validation;

    @Before
    public void setUp() {
        validation = new ValidationOfInputExpression();
    }

    @Test
    public void startValidation() {
        //arrange
        String firstExpression = "(7/0)";
        String firstError = "Делить на ноль нельзя";
        String secondExpression = "abd(4-6)";
        String secondError = "Выражение введено неверно";
        //act
        validation.startValidation(firstExpression);
        Assert.assertThat(validation.getError(), is(firstError));

        validation.startValidation(secondExpression);
        Assert.assertThat(validation.getError(), is(secondError));
    }
}
package ru.sbrf.course;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Student on 04.08.2016.
 */
public class CalculatorUTest {

    Calculator calculator;

    @BeforeClass
    public void init1() {
        calculator = new Calculator();
    }

    @Before
    public void init() {
        calculator = new Calculator();
    }

    @Test
    public void addTest() {
        Assert.assertTrue("2 + 5 != 7",calculator.add(2,5) == 7);
    }
}

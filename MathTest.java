package test;

import org.example.MathApp;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import java.util.Arrays;
import java.util.List;

/**
 * Тестовый класс для MathUtils
 */
public class MathTest {

    private MathApp mathUtils;

    @BeforeMethod(groups = {"utils", "advanced","exceptions"})
    public void setUp() {
        mathUtils = new MathApp();
    }

    @Test(groups = {"utils", "math"})
    public void testGcd() {
        System.out.println("Тестирование НОД");
        Assert.assertEquals(mathUtils.gcd(54, 24), 6);
        Assert.assertEquals(mathUtils.gcd(48, 18), 6);
        Assert.assertEquals(mathUtils.gcd(17, 13), 1);
        Assert.assertEquals(mathUtils.gcd(0, 5), 5);
    }

    @Test(groups = {"utils", "math"})
    public void testLcm() {
        System.out.println("Тестирование НОК");
        Assert.assertEquals(mathUtils.lcm(12, 18), 36);
        Assert.assertEquals(mathUtils.lcm(5, 7), 35);
        Assert.assertEquals(mathUtils.lcm(0, 5), 0);
    }

    @Test(groups = {"utils", "basic"})
    public void testIsEven() {
        System.out.println("Тестирование проверки четности");
        Assert.assertTrue(mathUtils.isEven(4));
        Assert.assertTrue(mathUtils.isEven(0));
        Assert.assertTrue(mathUtils.isEven(-6));
        Assert.assertFalse(mathUtils.isEven(7));
        Assert.assertFalse(mathUtils.isEven(-3));
    }

    @DataProvider(name = "palindromeData")
    public Object[][] palindromeData() {
        return new Object[][] {
                {121, true},
                {12321, true},
                {123, false},
                {0, true},
                {-121, false},
                {1221, true}
        };
    }

    @Test(groups = {"utils", "advanced"}, dataProvider = "palindromeData")
    public void testIsPalindrome(int number, boolean expected) {
        System.out.println("Тестирование палиндрома: " + number + " -> " + expected);
        Assert.assertEquals(mathUtils.isPalindrome(number), expected);
    }

    @Test(groups = {"utils", "sequences"})
    public void testGenerateFibonacci() {
        System.out.println("Тестирование генерации ряда Фибоначчи");
        List<Integer> expected5 = Arrays.asList(0, 1, 1, 2, 3);
        Assert.assertEquals(mathUtils.generateFibonacci(5), expected5);

        List<Integer> expected1 = Arrays.asList(0);
        Assert.assertEquals(mathUtils.generateFibonacci(1), expected1);

        List<Integer> expected2 = Arrays.asList(0, 1);
        Assert.assertEquals(mathUtils.generateFibonacci(2), expected2);
    }

    @Test(groups = {"utils", "sequences", "exceptions"},
            expectedExceptions = IllegalArgumentException.class)
    public void testGenerateFibonacciInvalidCount() {
        System.out.println("Тестирование генерации Фибоначчи с невалидным количеством");
        mathUtils.generateFibonacci(0);
    }

}

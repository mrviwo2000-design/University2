package test;

import org.example.App;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

/**
 * Тестовый класс для Calculator
 */
public class AppTest {

    private App calculator;

    @BeforeMethod(groups = {"basic", "arithmetic", "advanced","exceptions"})
    public void setUp() {
        calculator = new App();
    }

    @Test(groups = {"basic", "arithmetic"})
    public void testAdd() {
        System.out.println("Тестирование сложения");
        Assert.assertEquals(calculator.add(2, 3), 5.0);
        Assert.assertEquals(calculator.add(-2, 3), 1.0);
        Assert.assertEquals(calculator.add(0, 0), 0.0);
    }

    @Test(groups = {"basic", "arithmetic"})
    public void testSubtract() {
        System.out.println("Тестирование вычитания");
        Assert.assertEquals(calculator.subtract(5, 3), 2.0);
        Assert.assertEquals(calculator.subtract(3, 5), -2.0);
        Assert.assertEquals(calculator.subtract(0, 0), 0.0);
    }

    @Test(groups = {"basic", "arithmetic"})
    public void testMultiply() {
        System.out.println("Тестирование умножения");
        Assert.assertEquals(calculator.multiply(4, 5), 20.0);
        Assert.assertEquals(calculator.multiply(-4, 5), -20.0);
        Assert.assertEquals(calculator.multiply(0, 5), 0.0);
    }

    @Test(groups = {"basic", "arithmetic"})
    public void testDivide() {
        System.out.println("Тестирование деления");
        Assert.assertEquals(calculator.divide(10, 2), 5.0);
        Assert.assertEquals(calculator.divide(7, 2), 3.5);
    }

    @Test(groups = {"basic", "arithmetic", "exceptions"},
            expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        System.out.println("Тестирование деления на ноль");
        calculator.divide(10, 0);
    }

    @Test(groups = {"advanced", "math"})
    public void testPower() {
        System.out.println("Тестирование возведения в степень");
        Assert.assertEquals(calculator.power(2, 3), 8.0);
        Assert.assertEquals(calculator.power(5, 0), 1.0);
        Assert.assertEquals(calculator.power(10, 2), 100.0);
    }

    @Test(groups = {"advanced", "math"})
    public void testFactorial() {
        System.out.println("Тестирование факториала");
        Assert.assertEquals(calculator.factorial(0), 1L);
        Assert.assertEquals(calculator.factorial(1), 1L);
        Assert.assertEquals(calculator.factorial(5), 120L);
        Assert.assertEquals(calculator.factorial(7), 5040L);
    }

    @Test(groups = {"advanced", "math", "exceptions"},
            expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        System.out.println("Тестирование факториала отрицательного числа");
        calculator.factorial(-5);
    }

    @Test(groups = {"advanced", "math"})
    public void testIsPrime() {
        System.out.println("Тестирование проверки простых чисел");
        Assert.assertTrue(calculator.isPrime(2));
        Assert.assertTrue(calculator.isPrime(17));
        Assert.assertTrue(calculator.isPrime(97));
        Assert.assertFalse(calculator.isPrime(1));
        Assert.assertFalse(calculator.isPrime(4));
        Assert.assertFalse(calculator.isPrime(15));
    }

    @Test(groups = {"advanced", "arrays"})
    public void testFindMax() {
        System.out.println("Тестирование поиска максимума");
        double[] numbers = {1.5, 8.2, 3.7, 4.1, 2.9};
        Assert.assertEquals(calculator.findMax(numbers), 8.2);

        double[] negativeNumbers = {-5, -2, -10, -1};
        Assert.assertEquals(calculator.findMax(negativeNumbers), -1.0);
    }

    @Test(groups = {"advanced", "arrays", "exceptions"},
            expectedExceptions = IllegalArgumentException.class)
    public void testFindMaxEmptyArray() {
        System.out.println("Тестирование поиска максимума в пустом массиве");
        calculator.findMax(new double[]{});
    }

    @Test(groups = {"advanced", "arrays"})
    public void testCalculateAverage() {
        System.out.println("Тестирование вычисления среднего значения");
        double[] numbers = {1, 2, 3, 4, 5};
        Assert.assertEquals(calculator.calculateAverage(numbers), 3.0);

        double[] decimals = {1.5, 2.5, 3.5};
        Assert.assertEquals(calculator.calculateAverage(decimals), 2.5);
    }

    @DataProvider(name = "celsiusToFahrenheitData")
    public Object[][] celsiusToFahrenheitData() {
        return new Object[][] {
                {0, 32},
                {100, 212},
                {-40, -40},
                {20, 68},
                {37, 98.6}
        };
    }

    @Test(groups = {"advanced", "conversion"},
            dataProvider = "celsiusToFahrenheitData")
    public void testCelsiusToFahrenheit(double celsius, double expectedFahrenheit) {
        System.out.println("Тестирование конвертации: " + celsius + "°C -> " + expectedFahrenheit + "°F");
        Assert.assertEquals(calculator.celsiusToFahrenheit(celsius), expectedFahrenheit, 0.01);
    }

}

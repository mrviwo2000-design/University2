package org.example;

import java.util.Arrays;

/**
 * Класс калькулятора с основными математическими операциями
 */
public class App {

    /**
     * Сложение двух чисел
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Вычитание двух чисел
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Умножение двух чисел
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Деление двух чисел
     * @throws ArithmeticException если делитель равен 0
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль невозможно");
        }
        return a / b;
    }

    /**
     * Возведение числа в степень
     */
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    /**
     * Вычисление факториала числа
     * @throws IllegalArgumentException если число отрицательное
     */
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа не определен");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Проверка числа на простоту
     */
    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Нахождение максимального числа в массиве
     */
    public double findMax(double[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Массив не может быть пустым");
        }
        return Arrays.stream(numbers).max().getAsDouble();
    }

    /**
     * Вычисление среднего значения массива чисел
     */
    public double calculateAverage(double[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Массив не может быть пустым");
        }
        return Arrays.stream(numbers).average().getAsDouble();
    }

    /**
     * Конвертация градусов Цельсия в Фаренгейт
     */
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    /**
     * Основной метод для демонстрации работы приложения
     */
    public static void main(String[] args) {
        App calculator = new App();

        System.out.println("=== Калькулятор - Демонстрация ===");
        System.out.println("Сложение: 5 + 3 = " + calculator.add(5, 3));
        System.out.println("Вычитание: 10 - 4 = " + calculator.subtract(10, 4));
        System.out.println("Умножение: 6 * 7 = " + calculator.multiply(6, 7));
        System.out.println("Деление: 15 / 3 = " + calculator.divide(15, 3));
        System.out.println("Степень: 2^8 = " + calculator.power(2, 8));
        System.out.println("Факториал 5 = " + calculator.factorial(5));
        System.out.println("Число 17 простое? " + calculator.isPrime(17));

        double[] numbers = {1.5, 2.7, 3.1, 4.8, 2.2};
        System.out.println("Максимум в массиве: " + calculator.findMax(numbers));
        System.out.println("Среднее значение: " + calculator.calculateAverage(numbers));
        System.out.println("20°C в Фаренгейтах: " + calculator.celsiusToFahrenheit(20));

        try {
            System.out.println("Деление на ноль: " + calculator.divide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
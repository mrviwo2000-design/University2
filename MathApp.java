package org.example;
import java.util.ArrayList;
import java.util.List;

/**
 * Дополнительный класс с математическими утилитами
 */
public class MathApp {

    /**
     * Вычисление НОД (наибольшего общего делителя)
     */
    public int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

    /**
     * Вычисление НОК (наименьшего общего кратного)
     */
    public int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return Math.abs(a * b) / gcd(a, b);
    }

    /**
     * Проверка, является ли число четным
     */
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Проверка, является ли число палиндромом
     */
    public boolean isPalindrome(int number) {
        if (number < 0) return false;

        int original = number;
        int reversed = 0;

        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        return original == reversed;
    }

    /**
     * Генерация ряда Фибоначчи до указанного количества элементов
     */
    public List<Integer> generateFibonacci(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Количество элементов должно быть положительным");
        }

        List<Integer> fibonacci = new ArrayList<>();
        if (count >= 1) fibonacci.add(0);
        if (count >= 2) fibonacci.add(1);

        for (int i = 2; i < count; i++) {
            int next = fibonacci.get(i - 1) + fibonacci.get(i - 2);
            fibonacci.add(next);
        }

        return fibonacci;
    }
}
package ru.test.fibonacci;

import java.util.Scanner;

public class LastDigitBigFibonacciNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n + 1];
        if (n <= 6) {
            System.out.println(n);
            return;
        }
        arr[7]=3;
        arr[8]=1;
        for(int i = 9; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2] % 10;
        }
        System.out.println(arr[n] % 10);
    }
}

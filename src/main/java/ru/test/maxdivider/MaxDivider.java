package ru.test.maxdivider;

import java.util.Scanner;

class MaxDivider {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b= scanner.nextInt();
        System.out.println(maxDivider(a, b));
    }

    private static int maxDivider(int a, int b) {
        int result = 0;
        if (a == 0) {
            result = b;
        } else if (b == 0) {
            result = a;
        } else if (a >= b) {
            result = maxDivider(a % b, b);
        } else {
            result = maxDivider(a, b % a);
        }
        return result;
    }
}

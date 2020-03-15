package ru.test.fibonacci;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class HugeFibonacciNumberModal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger n = scanner.nextBigInteger();
        int m = scanner.nextInt();
        ArrayList<Integer> period = new ArrayList<>();
        period.add(0);
        period.add(1);
        int size = m * 6;
        for(int i = 2; i < size; i++){
            period.add((period.get(i - 1) + period.get(i - 2)) % m);
            if(period.get(i) == 1 && period.get(i-1) == 0){
                break;
            }
        }
        long periodValue = period.size() - 2;
        System.out.println(period.get(n.mod(BigInteger.valueOf(periodValue)).intValue()));
    }
}

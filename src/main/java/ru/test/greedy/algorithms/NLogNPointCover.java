package ru.test.greedy.algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class NLogNPointCover {

    public static void main(String[] args) {
        Map<Integer, Integer> result = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int lineSize = scanner.nextInt();
        scanner.nextLine();
        String string = scanner.nextLine();
        String[] arrString = string.trim().split(" ");
        List<Integer> points = Arrays.stream(arrString).map(Integer::valueOf).sorted()
                .collect(Collectors.toList());
        int i = 0;
        while(i < points.size()) {
            int lineEnd = points.get(i) + lineSize;
            result.put(points.get(i), lineEnd);
            i++;
            while (i < points.size() && points.get(i) <= lineEnd) {
                i++;
            }
        }
        System.out.println(result);
    }

}

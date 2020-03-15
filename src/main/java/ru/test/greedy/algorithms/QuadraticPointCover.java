package ru.test.greedy.algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class QuadraticPointCover {

    public static void main(String[] args) {
        Map<Integer, Integer> result = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int lineSize = scanner.nextInt();
        scanner.nextLine();
        String string = scanner.nextLine();
        String[] arrString = string.split(" ");
        List<Integer> points = Arrays.stream(arrString).map(Integer::valueOf).collect(
                Collectors.toList());
        while(!points.isEmpty()) {
            Integer min = Collections.min(points);
            result.put(min, min + lineSize);
            remove(min, min + lineSize, points);
        }
        System.out.println(result);
    }

    private static void remove(Integer start, Integer end, List<Integer> points) {
        for(Integer point : new ArrayList<>(points)) {
            if(point >= start && point <= end) {
                points.remove(point);
            }
        }
    }

}

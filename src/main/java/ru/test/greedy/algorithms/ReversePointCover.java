package ru.test.greedy.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ReversePointCover {

    static class Segment {
        int start;
        int end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        Integer getStart() {
            return start;
        }

        Integer getEnd() {
            return end;
        }
    }

    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        List<Segment> lines = readValues();
        int value = lines.get(0).getEnd();
        result.add(value);
        for (Segment seg : lines) {
            if (!(value >= seg.getStart() && value <= seg.getEnd())) {
                value = seg.getEnd();
                result.add(value);
            }
        }
        System.out.println(result.size());
        for (Integer integer : result) {
            System.out.print(integer);
            System.out.print(" ");
        }
    }

    private static List<Segment> readValues() {
        List<Segment> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0; i <= n; i++) {
            String[] args = scanner.nextLine().split(" ");
            if (1 < args.length) {
                Segment seg = new Segment(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
                result.add(seg);
            }
        }
        result.sort(Comparator.comparing(Segment::getEnd));
        return result;
    }

}

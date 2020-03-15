package ru.test.greedy.algorithms;

import java.util.*;

public class ContinuousBackpack {

    private static double capacity;

    static class Subject {
        private double value;
        private double cost;
        private double weight;
        public Subject(Integer cost, Integer weight) {
            this.cost = cost;
            this.weight = weight;
            this.value = this.cost / this.weight;
        }

        public double getCost() {
            return cost;
        }

        public double getValue() {
            return value;
        }

        public double getWeight() {
            return weight;
        }
    }

    public static void main(String[] args) {
        double result = 0;
        double weight = 0;
        List<Subject> list = readValues();
        if (0 < capacity) {
            for (Subject subject : list) {
                double oldW = weight;
                weight += subject.getWeight();
                if (weight <= capacity) {
                    result += subject.getCost();
                } else if (weight > capacity) {
                    double diffPercent = ((capacity - oldW) / subject.getWeight());
                    if (0 < diffPercent) {
                        result += subject.cost * diffPercent;
                    }
                }
            }
        }
        System.out.println(result);
    }

    private static List<Subject> readValues() {
        List<Subject> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String[] conditions = scanner.nextLine().split(" ");
        int n = Integer.parseInt(conditions[0]);
        capacity = Integer.parseInt(conditions[1]);
        for(int i=0; i < n; i++) {
            String[] args = scanner.nextLine().split(" ");
            if (1 < args.length) {
                Subject seg = new Subject(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
                result.add(seg);
            }
        }
        result.sort(Collections.reverseOrder(Comparator.comparing(Subject::getValue)));
        return result;
    }

}

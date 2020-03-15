package ru.test.greedy.algorithms;

import java.util.*;

public class HuffmanCodes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String testString = scanner.nextLine();
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(s -> s.frequency));
        Map<Character, Integer> charFrequencyMap = getCharFrequency(testString);
        int countSymbols = charFrequencyMap.size();
        charFrequencyMap.forEach((key, value) -> {
            Node node = new Node(key, value);
            queue.add(node);
        });
        if (charFrequencyMap.size() != 1) {
            Node huffmanTree = null;
            for(int k = countSymbols + 1; k <= 2*countSymbols - 1; k++) {
                Node iMin = queue.poll();
                Node jMin = queue.poll();
                if (iMin != null && jMin != null) {
                    Node vertex = new Node(null,iMin.frequency + jMin.frequency);
                    vertex.addChild(iMin);
                    vertex.addChild(jMin);
                    huffmanTree = vertex;
                    queue.add(vertex);
                }
            }
            StringBuilder result = new StringBuilder();
            Map<Character, String> huffmanMap = new HashMap<>();
            if (huffmanTree != null) {
                for (Character value : charFrequencyMap.keySet()) {
                    huffmanMap.put(value, getHuffmanCode(huffmanTree, value));
                }
            }
            for(Character value : testString.toCharArray()) {
                result.append(huffmanMap.get(value));
            }
            System.out.println(charFrequencyMap.size() + " " + result.length());
            huffmanMap.forEach((key, value) -> {
                System.out.println(key + ": " + value);
            });
            System.out.println(result.toString());
        } else {
            System.out.println(1 + " " + testString.length());
            System.out.println(testString.charAt(0) + ": " + 0);
            StringBuilder result = new StringBuilder();
            for(Character value : testString.toCharArray()) {
                result.append(0);
            }
            System.out.println(result.toString());
        }

    }

    private static String getHuffmanCode(Node vertex, Character stringChar) {
        StringBuilder builder = new StringBuilder();
        List<Node> children = vertex.children;
        if (children != null) {
            Node childLeft  = children.get(0);
            Node childRight = children.get(1);
            if (childLeft.isContains(stringChar)) {
                builder.append("0");
                builder.append(getHuffmanCode(childLeft, stringChar));
            } else if (childLeft.isEqual(stringChar)) {
                builder.append("0");
            } else if (childRight.isContains(stringChar)) {
                builder.append("1");
                builder.append(getHuffmanCode(childRight, stringChar));
            } else if (childRight.isEqual(stringChar)) {
                builder.append("1");
            }
        }
        return builder.toString();
    }

    private static Map<Character, Integer> getCharFrequency(String testString) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character value : testString.toCharArray()) {
            map.merge(value, 1, Integer::sum);
        }
        return map;
    }

    static class Node {
        StringBuilder name = new StringBuilder();
        Character value;
        int frequency;
        List<Node> children;

        Node(Character value, int frequency) {
            this.frequency = frequency;
            this.value = value;
        }

        void appendName(String value) {
            this.name.append(value);
        }

        void addChild(Node child) {
            if (children == null) {
                children = new ArrayList<>();
            }
            children.add(child);
            if (child.value == null) {
                appendName(child.name.toString());
            } else {
                appendName(child.value.toString());
            }
        }

        boolean isContains(Character value) {
            return children != null && this.name.toString().contains(value.toString());
        }

        boolean isEqual(Character value) {
            return children == null && this.value.equals(value);
        }
    }

}

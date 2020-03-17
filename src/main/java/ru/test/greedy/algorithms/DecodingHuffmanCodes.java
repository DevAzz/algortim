package ru.test.greedy.algorithms;

import java.util.*;

public class DecodingHuffmanCodes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> params = new ArrayList<>();
        String[] count = scanner.nextLine().split(" ");
        for(int i = 0; i<Integer.parseInt(count[0]); i++) {
            params.add(scanner.nextLine());
        }
        params.add(scanner.nextLine());

        char[] testString = params.get(params.size() - 1).toCharArray();
        Map<String, Character> dict = parseParams(params);
        StringBuilder builder = new StringBuilder();
        StringBuilder charBuilder = new StringBuilder();
        charBuilder.append(testString[0]);
        int i = 1;
        do {
            Character symbol = dict.get(charBuilder.toString());
            if(symbol != null) {
                builder.append(symbol);
                charBuilder.setLength(0);
            }
            if (i < testString.length) {
                char bit = testString[i];
                charBuilder.append(bit);
            }
            i++;
        } while(i <= testString.length);
        System.out.println(builder.toString());
    }

    private static Map<String, Character> parseParams(List<String> params) {
        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < params.size() - 1; i++) {
            String param = params.get(i);
            Character symbol = param.substring(0, 1).charAt(0);
            String value = param.substring(3);
            map.put(value, symbol);
        }
        return map;
    }

}

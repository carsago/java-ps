package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * https://www.acmicpc.net/problem/2108
 */
public class 통계학 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int round = Integer.parseInt(br.readLine());
        List<Integer> values = new ArrayList<>();
        double sum = 0;
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < round; i++) {
            int value = Integer.parseInt(br.readLine());
            values.add(value);
            sum += value;
            if (maps.containsKey(value)) {
                maps.put(value, maps.get(value) + 1);
            } else {
                maps.put(value, 1);
            }
        }

        int max = Integer.MIN_VALUE;
        List<Integer> many = new ArrayList<>();

        for (Integer value : maps.values()) {
            if (value > max) {
                max = value;
            }
        }

        for (Integer value : maps.keySet()) {
            if (max == maps.get(value)) {
                many.add(value);
            }
        }

        int third;
        many.sort(Comparator.naturalOrder());
        if (many.size() > 1) {
            third = many.get(1);
        } else {
            third = many.get(0);
        }

        values.sort(Comparator.naturalOrder());


        int size = values.size();
        int first = (int) Math.round(sum / size);
        int second = values.get(size / 2);
        int forth = Math.abs(values.get(size - 1) - values.get(0));


        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(forth);
    }
}

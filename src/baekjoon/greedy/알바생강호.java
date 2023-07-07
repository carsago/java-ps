package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/1758
 */
public class 알바생강호 {

    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int round = Integer.parseInt(br.readLine());
        List<Integer> tips = new ArrayList<>();
        for (int i = 0; i < round; i++) {
            tips.add(Integer.parseInt(br.readLine()));
        }

        tips.sort(Comparator.reverseOrder());
        int totalTips = 0;
        for (int i = 0; i < tips.size(); i++) {
            int value = tips.get(i) - i;
            if (value <= 0) {
                break;
            }
            totalTips += value;
        }
        System.out.println(totalTips);
    }
}

package baekjoon.classthree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 리모컨투 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int goal = Integer.parseInt(br.readLine());
        int countOfBreak = Integer.parseInt(br.readLine());
        boolean[] falseButtons = new boolean[10];

        if (countOfBreak > 0) {
            String[] values = br.readLine().split(" ");
            for (int i = 0; i < values.length; i++) {
                falseButtons[Integer.parseInt(values[i])] = true;
            }
        }

        int answer = Math.abs(goal - 100);
        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            boolean able = true;
            for (int j = 0; j < str.length(); j++) {
                if (falseButtons[Character.getNumericValue(str.charAt(j))]) {
                    able = false;
                    break;
                }
            }

            if (!able) {
                continue;
            } else {
                int other = Math.abs(goal - i) + String.valueOf(i).length();
                if (answer > other) {
                    answer = other;
                }
            }
        }

        System.out.println(answer);
    }
}

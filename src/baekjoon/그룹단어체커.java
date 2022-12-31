package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 백준 1316 그룹 단어 체커
 * https://www.acmicpc.net/problem/1316
 */
public class 그룹단어체커 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfNumber = scanner.nextInt();
        int answer = 0;

        for (int i = 0; i < countOfNumber; i++) {
            if (isGroupNumber(scanner.next())) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean isGroupNumber(String word) {
        List<Character> values = new ArrayList<>();
        values.add(word.charAt(0));

        for (int i = 1; i < word.length(); i++) {
            if (!(word.charAt(i) == word.charAt(i - 1))) {
                if (values.contains(word.charAt(i))) {
                    return false;
                }
                values.add(word.charAt(i));
            }
        }
        return true;
    }
}
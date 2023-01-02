package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 백준 1181 단어정렬
 * https://www.acmicpc.net/problem/1181
 */
public class 단어정렬 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        int countOfWord = scanner.nextInt();
        words.add(scanner.next());

        for (int i = 1; i < countOfWord; i++) {
            addToSortedState(words,scanner.next());
        }

        printAnswer(words);
    }

    private static void addToSortedState(List<String> words,
                                         String recentWord) {

        //이미 단어가 포함되어 있는 경우
        if (words.contains(recentWord)) {
            return;
        }

        for (int i = 0; i < words.size(); i++) {
            String loopWord = words.get(i);
            if (loopWord.length() > recentWord.length()) {
                words.add(i, recentWord);
                return;
            }

            if (loopWord.length() == recentWord.length()) {
                if (loopWord.compareTo(recentWord) > 0) {
                    words.add(i, recentWord);
                    return;
                }
            }
        }

        //단어가 마지막에 저장되어야 하는 경우
        words.add(recentWord);
    }

    private static void printAnswer(List<String> words) {
        for (String word : words) {
            System.out.println(word);
        }
    }
}

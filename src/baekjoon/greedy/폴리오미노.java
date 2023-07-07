package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1343, https://www.acmicpc.net/problem/1343
 */
public class 폴리오미노 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String question = br.readLine();
        String AAAA = "AAAA";
        String BB = "BB";

        question = question.replaceAll("XXXX", AAAA);
        question = question.replaceAll("XX", BB);
        if (question.contains("X")) {
            System.out.println(-1);
        } else {
            System.out.println(question);
        }
    }
}

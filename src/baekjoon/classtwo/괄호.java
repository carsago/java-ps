package baekjoon.classtwo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/9012
 */
public class 괄호 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int round = Integer.parseInt(br.readLine());

        for (int i = 0; i < round; i++) {
            Stack<Character> values = new Stack<>();
            String s = br.readLine();
            boolean answer = true;
            for (int j = 0; j < s.length(); j++) {
                char value = s.charAt(j);
                if (value == ')') {
                    if (values.empty()) {
                        answer = false;
                        break;
                    } else {
                        values.pop();
                    }
                } else {
                    values.push(value);
                }
            }

            if (!values.empty()) {
                answer = false;
            }


            if (answer) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

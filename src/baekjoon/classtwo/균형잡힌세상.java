package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/4949
 */
public class 균형잡힌세상 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();

        while (true) {

            String line = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean answer = true;

            if (line.equals(".")) {
                break;
            }

            for (int i = 0; i < line.length(); i++) {
                char value = line.charAt(i);

                if (value == '[' || value == '(') {
                    stack.push(value);
                    continue;
                }



                if (value == ']') {
                    if (stack.empty()) {
                        answer = false;
                        break;
                    }

                    Character peek = stack.peek();

                    if (peek == '[') {
                        stack.pop();
                    } else {
                        answer = false;
                        break;
                    }
                }

                if (value == ')') {
                    if (stack.empty()) {
                        answer = false;
                        break;
                    }

                    Character peek = stack.peek();

                    if (peek == '(') {
                        stack.pop();
                    } else {
                        answer = false;
                        break;
                    }
                }
            }

            if (answer && stack.empty()) {
                sb.append("yes" + '\n');
            } else {
                sb.append("no" + '\n');
            }
        }

        System.out.println(sb);
    }
}

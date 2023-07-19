package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/1874
 */
public class 스택수열 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();


        int currentValue = 1;
        boolean possible = true;
        for (int i = 1; i <= n; i++) {
            int value = Integer.parseInt(br.readLine());

            while (currentValue <= value) {
                stack.push(currentValue++);
                sb.append("+" + '\n');
            }

            if (!stack.contains(value)) {
                possible = false;
                break;
            }

            while (true) {
                sb.append("-" + '\n');
                if (stack.pop() == value) {
                    break;
                }
            }

        }
        if (possible) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}

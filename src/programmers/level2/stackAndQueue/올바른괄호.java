package programmers.level2.stackAndQueue;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */
public class 올바른괄호 {

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}

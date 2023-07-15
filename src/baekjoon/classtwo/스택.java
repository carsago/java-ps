package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/10828
 */
public class 스택 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        MyStack stack = new MyStack(n);
        for (int i = 0; i < n; i++) {
            String[] values = br.readLine().split(" ");
            if (values[0].equals("push")) {
                stack.push(Integer.parseInt(values[1]));
            } else if (values[0].equals("top")) {
                System.out.println(stack.top());
            } else if (values[0].equals("size")) {
                System.out.println(stack.size);
            } else if (values[0].equals("empty")) {
                System.out.println(stack.empty());
            } else if (values[0].equals("pop")) {
                System.out.println(stack.pop());
            }

        }
    }


    static class MyStack  {
        int[] array;
        int size = 0;

        public MyStack(int n) {
            this.array = new int[n];
        }

        public void push(int value) {
            array[size] = value;
            size++;
        }

        public int pop() {
            if (size == 0) {
                return -1;
            }  else {
                int get = array[size-1];
                size--;
                return get;
            }
        }
        public int empty() {
            if (size == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        public int top() {
            if (size == 0) {
                return -1;
            } else {
                return array[size-1];
            }
        }
    }
}


package baekjoon.classtwo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/10845
 */
public class 큐 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        MyQueue q = new MyQueue(n);
        for (int i = 0; i < n; i++) {
            String[] values = br.readLine().split(" ");
            if (values[0].equals("push")) {
                q.push(Integer.parseInt(values[1]));
            } else if (values[0].equals("front")) {
                System.out.println(q.front());
            } else if (values[0].equals("size")) {
                System.out.println(q.size);
            } else if (values[0].equals("empty")) {
                System.out.println(q.empty());
            } else if (values[0].equals("pop")) {
                System.out.println(q.pop());
            } else if (values[0].equals("back")) {
                System.out.println(q.back());
            }

        }
    }


    static class MyQueue {
        int[] array;
        int size = 0;

        public MyQueue(int maxSize) {
            this.array = new int[maxSize];
        }

        public void push(int value) {
            array[size] = value;
            size++;
        }

        public int pop() {
            if (size == 0) {
                return -1;
            } else {
                int firstValue = array[0];
                int[] newArray = new int[array.length+1];
                for (int i = 1; i <= size; i++) {
                    newArray[i - 1] = array[i];
                }
                array = newArray;
                size--;
                return firstValue;

            }
        }

        public int empty() {
            if (size == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        public int front() {
            if (size != 0) {
                return array[0];
            } else {
                return -1;
            }
        }

        public int back() {
            if (size != 0) {
                return array[size-1];
            } else {
                return -1;
            }
        }
    }
}

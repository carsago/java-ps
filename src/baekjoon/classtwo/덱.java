package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/10866
 */
public class 덱 {


    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        MyDeque deque = new MyDeque();
        for (int i = 0; i < n; i++) {
            String[] values = br.readLine().split(" ");
            if (values[0].equals("push_front")) {
                deque.push_front(Integer.parseInt(values[1]));
            } else if (values[0].equals("push_back")) {
                deque.push_back(Integer.parseInt(values[1]));
            } else if (values[0].equals("pop_front")) {
                System.out.println(deque.pop_front());
            } else if (values[0].equals("pop_back")) {
                System.out.println(deque.pop_back());
            } else if (values[0].equals("size")) {
                System.out.println(deque.size);
            } else if (values[0].equals("empty")) {
                System.out.println(deque.empty());
            } else if (values[0].equals("front")) {
                System.out.println(deque.front());
            } else if (values[0].equals("back")) {
                System.out.println(deque.back());
            }
        }
    }

    static class MyDeque {
        int[] array = new int[2];
        int size = 0;
        int front = 1;
        int back = 1;


        public void push_front(int value) {
            array[front] = value;
            if (front == 0) {
                int[] newArray = new int[array.length + 20];
                for (int i = front; i <= back; i++) {
                    newArray[i+10] = array[i];
                }
                array = newArray;
                front += 10;
                back += 10;
            }
            front--;
            size++;
        }

        public void push_back(int value) {
            if (back == array.length - 1) {
                int[] newArray = new int[array.length + 20];
                for (int i = front; i <= back; i++) {
                    newArray[i+10] = array[i];
                }
                array = newArray;
                front += 10;
                back += 10;
            }
            back++;
            size++;
            array[back] = value;

        }

        public int pop_front() {
            if (size == 0) {
                return -1;
            } else {
                int value = array[front + 1];
                front++;
                size--;
                return value;
            }
        }

        public int pop_back() {
            if (size == 0) {
                return -1;
            } else {
                int value = array[back];
                back--;
                size--;
                return value;
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
            if (size == 0) {
                return -1;
            } else {
                return array[front + 1];
            }
        }


        public int back() {
            if (size == 0) {
                return -1;
            } else {
                return array[back];
            }
        }
    }
}



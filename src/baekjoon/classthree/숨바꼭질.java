package baekjoon.classthree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/1697
 */
public class 숨바꼭질 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[] array = new int[100001];
        array[N] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        while (array[K] == 0) {
            Integer value = queue.poll();
            if (value - 1 >= 0) {
                if (value - 1 <= 100000 && array[value - 1] == 0) {
                    queue.add(value - 1);
                    array[value - 1] = array[value] + 1;
                }
            }

            if (value + 1 <= 100000 && array[value + 1] == 0) {
                queue.add(value + 1);
                array[value + 1] = array[value] + 1;
            }

            if (value * 2 <= 100000 && array[value * 2] == 0) {
                queue.add(value * 2);
                array[value * 2] = array[value] + 1;
            }
        }
        System.out.println(array[K] - 1);
    }
}

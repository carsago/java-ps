package programmers.level2.sort;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748
 */
public class K번째수 {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };
        solution(array, commands);
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int[] values = new int[end - start+1];
            int idx = 0;
            for (int j = start - 1; j < end; j++) {
                values[idx] = array[j];
                idx++;
            }

            Arrays.sort(values);
            answer[i] = values[commands[i][2] - 1];
        }
        return answer;
    }
}

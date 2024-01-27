package programmers.level2.dfsandbfs;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {

    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] map = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < map.length; i++) {
            if (!map[i]) {
                map[i] = true;
                queue.add(i);
                while (!queue.isEmpty()) {
                    Integer value = queue.poll();
                    for (int j = 0; j < computers[value].length; j++) {
                        int next = computers[value][j];
                        if (next == 0) {
                            continue;
                        }
                        if (map[j]) {
                            continue;
                        }

                        map[j] = true;
                        queue.add(j);
                    }
                }
                answer++;
            }
        }


        return answer;
    }
}

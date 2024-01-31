package programmers.level2;

import java.util.Collections;
import java.util.PriorityQueue;

public class 디펜스게임 {

    public int solution(int n, int k, int[] enemy) {
        if (k >= enemy.length) {
            return enemy.length;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        /**
         * n = 1
         * 4 4 4 4 4
         *
         * k 1
         */
        for (int i = 0; i < enemy.length; i++) {
            queue.add(enemy[i]);
            n -= enemy[i];
            if (n < 0) {
                if (k > 0) {
                    n += queue.poll();
                    k--;
                } else {
                    return i;
                }
            }
        }

        return enemy.length;

    }
}

package programmers.level2.stackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42584
 */
public class 주식가격 {

    public int[] solution(int[] prices) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int price : prices) {
            queue.add(price);
        }

        int idx = 0;

        while (!queue.isEmpty()) {
            int time = 0;
            boolean clear = false;
            Integer value = queue.poll();
            for (int i = idx; i < prices.length; i++) {
                if (prices[i] < value) {
                    answer.add(time);
                    break;
                }
                time++;
            }
            if (!clear) {
                answer.add(time);
            }
            idx++;
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

package programmers.level2.stackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */
public class 기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> speedQueue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add(progresses[i]);
            speedQueue.add(speeds[i]);
        }

        while (!queue.isEmpty()) {
            Integer progress = queue.poll();
            Integer speed = speedQueue.poll();
            int day = 0;
            int count = 1;
            while (true) {
                day++;
                progress += speed;
                if (progress >= 100) {
                    break;
                }
            }

            while (!queue.isEmpty()) {
                if (queue.peek() + (speedQueue.peek() * day) >= 100) {
                    queue.poll();
                    speedQueue.poll();
                    count++;
                } else {
                    break;
                }
            }
            answer.add(count);
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

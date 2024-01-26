package programmers.level2.stackAndQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class 프로세스 {

    public static void main(String[] args) {
        int[] a = {2, 1, 3, 2};
        System.out.println(solution(a, 2));
    }

    public static int solution(int[] priorities, int location) {
        // 우선순위 큐 선언(내림 차순)
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        // 우선순위 큐에 우선순위 요소 추가
        for (int i : priorities) {
            queue.offer(i);
        }

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 기존 우선순위 배열 순회
            for (int i = 0; i < priorities.length; i++) {
                // 현재 작업의 위치 찾기
                if (queue.peek() == priorities[i]) {
                    queue.poll();
                    answer++;

                    // 현재 작업이 location과 같으면 answer 반환
                    if (location == i) {
                        return answer;
                    }
                }
            }
        }

        return answer;
    }
}

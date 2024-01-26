package programmers.level2.sort;

import java.util.Arrays;

public class H인덱스 {

    public int solution(int[] citations) {
        // 6 5 3 1 0
        // 1 2 3 4

        Arrays.sort(citations);
        int answer = 0;

        for (int i = 0; i < citations.length; i++) {
            int value = citations.length - i;
            if (citations[i] >= value) {
                answer = value;
                break;
            }
        }
        return answer;
    }
}

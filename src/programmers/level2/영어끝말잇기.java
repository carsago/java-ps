package programmers.level2;


import java.util.HashMap;
import java.util.Map;

public class 영어끝말잇기 {

    public static void main(String[] args) {
        String[] a = {"hello", "one", "even", "never", "now", "world", "draw"};
        solution(2, a);

    }

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Map<String, Boolean> map = new HashMap<>();

        char last = words[0].charAt(0);

        // 6  1 2 3 4 5 6
        // 2명이서 해 6이면 3번째 사람의 2번째 차리
        // (i + 1) % 2
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (map.containsKey(word) || word.charAt(0) != last) {
                answer[1] = (i / n) + 1;
                answer[0] = (i % n) + 1;
                return answer;
            }

            map.put(word, true);
            last = words[i].charAt(words[i].length() - 1);
        }

        return answer;
    }
}

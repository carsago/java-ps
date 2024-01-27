package programmers.level2.dfsandbfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class 단어변환 {

    public static void main(String[] args) {
        String[] answer = {"hot", "dot", "dog", "lot", "log"};
        System.out.println(solution("hit", "cog", answer));
    }

    public static int solution(String begin, String target, String[] words) {
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(begin, 0));
        List<String> list = Arrays.stream(words)
                .collect(Collectors.toList());

        while (!queue.isEmpty()) {
            Info info = queue.poll();
            for (int i = 0; i < words.length; i++) {

                if (canConvert(info.value, words[i])) {
                    if (words[i].equals(target)) {
                        return info.length +1;
                    }
                    queue.add(new Info(words[i], info.length + 1));
                    list.remove(words[i]);
                }
            }
        }

        int answer = 0;
        return answer;
    }

    private static boolean canConvert(String word1, String word2){
        int diffCnt = 0;
        for (int i = 0; i<word1.length(); i++){
            if (word1.charAt(i) != word2.charAt(i)){
                diffCnt++;
            }
        }
        return diffCnt ==1;
    }

    static class Info {
        String value;
        int length;

        public Info(String value, int length) {
            this.value = value;
            this.length = length;
        }
    }
}

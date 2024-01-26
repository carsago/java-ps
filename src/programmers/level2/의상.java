package programmers.level2;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 */
public class 의상 {

    public static void main(String[] args) {

    }

    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String type = clothe[1];
            if (map.containsKey(type)) {
                map.put(type, map.get(type) + 1);
            } else {
                map.put(type, 1);
            }
        }

        for( String key : map.keySet()){
            answer *= map.get(key)+1;
        }
        answer -= 1;
        return answer;
    }
}

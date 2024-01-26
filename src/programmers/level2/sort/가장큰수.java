package programmers.level2.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 */
public class 가장큰수 {

    public String solution(int[] numbers) {
        List<String> list = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());

        Collections.sort(list, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder sb = new StringBuilder();
        if (list.get(0).startsWith("0")) {
            return "0";
        }
        for (String value : list) {
            sb.append(value);
        }
        return sb.toString();
    }
}

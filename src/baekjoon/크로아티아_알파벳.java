package baekjoon;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 백준 2941 크로아티아 알파벳
 * https://www.acmicpc.net/problem/2941
 */
public class 크로아티아_알파벳 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<Character, List<String>> maps = Map.of(
                'c', List.of("c=", "c-"),
                'd', List.of("dz=", "d-"),
                'l', List.of("lj"),
                'n', List.of("nj"),
                's', List.of("s="),
                'z', List.of("z=")
        );
        String word = scanner.next();
        int answer = 0;

        for (int i = 0; i < word.length(); i++) {

            //크로아티아 알파벳과 첫글자가 동일한 단어가 존재하는 경우.
            if (maps.containsKey(word.charAt(i))) {
                boolean clear = false;

                List<String> strings = maps.get(word.charAt(i));
                for (String string : strings) {
                    //크로아티아 알파벳인 경우
                    if (word.substring(i).startsWith(string)) {
                        clear = true;
                        answer++;
                        i += string.length() -1;
                        break;
                    }
                }

                //존재하나 크로아티아 알파벳은 아닌 경우
                if (!clear) {
                    answer++;
                }
                // 그외
            } else {
                answer++;
            }
        }

        System.out.println(answer);
    }
}


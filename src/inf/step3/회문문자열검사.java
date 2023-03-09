package inf.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 회문문자열검사 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int countOfNumber = Integer.parseInt(st.nextToken());

        String[] words = new String[countOfNumber];

        for (int i = 0; i < countOfNumber; i++) {
            words[i] = br.readLine().toLowerCase();
        }

        for (String word : words) {
            int wordLength = word.length();
            boolean isNo = false;

            for (int j = 0; j < wordLength / 2; j++) {
                if (word.charAt(j) != word.charAt(wordLength - 1 - j)) {
                    System.out.println("NO");
                    isNo = true;
                    break;
                }
            }

            if (!isNo) {
                System.out.println("YES");
            }
        }
    }
}

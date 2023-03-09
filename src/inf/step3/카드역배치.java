package inf.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 카드역배치 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int playCount = 10;
        //TODO
        int[][] numbers = new int[playCount][2];
        int[] cards = new int[21];

        for (int i = 0; i < cards.length; i++) {
            cards[i] = i;
        }

        for (int i = 0; i < playCount; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            numbers[i][0] = start;
            numbers[i][1] = end;
        }

        for (int[] number : numbers) {
            int start = number[0];
            int end = number[1];
            int[] orders = Arrays.copyOfRange(cards, start, end + 1);

            int g = end - start;
            for (int i = 0; i <= g; i++) {
                cards[start + i] = orders[g - i];
            }
        }
        for (int i = 1; i < cards.length; i++) {
            System.out.print(i +" ");
        }
    }
}

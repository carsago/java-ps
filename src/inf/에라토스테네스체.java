package inf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 에라토스테네스체 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //50까지 수 중 소수를 출력해라
    public static void main(String[] args) throws IOException {
        boolean[] values = new boolean[51];
        values[0] = true;
        values[1] = true;

        for (int i = 2; i < values.length; i++) {
            if (!values[i]) {
                for (int j = i + i; j < values.length; j+= i) {
                    values[j] = true;
                }
            }
        }

        for (int i = 1; i < values.length; i++) {
            if (!values[i]) {
                System.out.println(i);
            }
        }

    }
}

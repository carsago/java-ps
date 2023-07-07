package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬수 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while (true) {
            String value = br.readLine();
            if (Integer.parseInt(value) == 0) {
                break;
            }
            int len = value.length();
            boolean answer = true;
            for (int i = 0; i < len / 2; i++) {
                if (value.charAt(i) != value.charAt(len - 1 - i)) {
                    answer = false;
                    break;
                }
                ;
            }
            if (answer == true) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}

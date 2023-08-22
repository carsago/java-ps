package baekjoon.classtwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * https://www.acmicpc.net/problem/15829
 */
public class Hashing {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int L = Integer.parseInt(br.readLine());
        String word = br.readLine();

        BigInteger sum = BigInteger.ZERO;
        int r = 31;
        for (int i = 0; i < word.length(); i++) {
            int value = (int) word.charAt(i) - 96;

            sum = sum.add(BigInteger.valueOf(value).multiply(BigInteger.valueOf(r).pow(i)));
        }
        System.out.println(sum.remainder(BigInteger.valueOf(1234567891)));
    }
}

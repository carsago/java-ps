package baekjoon;

import java.util.ArrayList;
import java.util.List;

/**
 * 백준 4673 셀프넘버
 * https://www.acmicpc.net/problem/4673
 */
public class 셀프넘버 {

    public static void main(String[] args) {
        List<Integer> selfNumbers = new ArrayList<>();
        addSelfNumber(selfNumbers);

        printAnswer(selfNumbers);
    }

    private static void addSelfNumber(List<Integer> selfNumbers) {
        for (int i = 1; i < 10001; i++) {
            if (isSelfNumber(i)) {
                selfNumbers.add(i);
            }
        }
    }

    private static boolean isSelfNumber(int targetNumber) {
        for (int i = 1; i < targetNumber; i++) {
            if (targetNumber == calculateByFunction(i)) {
                return false;
            }
        }
        return true;
    }

    private static int calculateByFunction(int number) {
        int value = number;
        while (number > 0) {
            value += number % 10;
            number = number / 10;
        }
        return value;
    }

    private static void printAnswer(List<Integer> selfNumbers) {
        for (Integer selfNumber : selfNumbers) {
            System.out.println(selfNumber);
        }
    }
}

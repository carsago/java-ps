package baekjoon.classfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/1043
 */
public class 거짓말 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int people = Integer.parseInt(s[0]);
        int partyNumber = Integer.parseInt(s[1]);
        String[] s2 = br.readLine().split(" ");
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i < s2.length; i++) {
            factors.add(Integer.parseInt(s2[i]));
        }

        List<Integer>[] party = new LinkedList[partyNumber];

        for (int i = 0; i < partyNumber; i++) {
            party[i] = new LinkedList<>();
            String[] values = br.readLine().split(" ");
            for (int j = 1; j < values.length; j++) {
                party[i].add(Integer.parseInt(values[j]));
            }
        }

        int answer = partyNumber;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] cleanParty = new boolean[partyNumber];
        boolean[] cleanPeople = new boolean[people + 1];

        for (Integer factor : factors) {
            queue.add(factor);
            cleanPeople[factor] = true;
        }

        while (!queue.isEmpty()) {
            Integer value = queue.poll();

            for (int i = 0; i < party.length; i++) {
                if (cleanParty[i]) {
                    continue;
                }

                if (!party[i].contains(value)) {
                    continue;
                }

                for (int j = 0; j < party[i].size(); j++) {
                    Integer target = party[i].get(j);
                    if (cleanPeople[target]) {
                        continue;
                    }
                    queue.add(target);
                    cleanPeople[target] = true;
                }

                cleanParty[i] = true;
                answer--;
            }
        }
        System.out.println(answer);
    }
}

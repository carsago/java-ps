package programmers.level2;

import java.util.PriorityQueue;

public class 광물캐기 {
    /**
     * 다이아 1
     * 돌 5
     *
     * 아이언 5
     * 돌 0
     * 돌로 캐면 25
     */

    public static void main(String[] args) {
        int[] a = {1, 0, 1};
        String[] b = {"iron", "iron", "iron", "iron", "diamond", "diamond", "diamond"};
        System.out.println("answer = " + solution(a, b));
    }

    public static int solution(int[] picks, String[] minerals) {
        int picksCount = 0;
        for (int pick : picks) {
            picksCount += pick;
        }
        PriorityQueue<Mineral> queue = new PriorityQueue<>();

        int d = 0;
        int ir = 0;
        int s = 0;

        for (int i = 0; i < minerals.length; i++) {
            if (minerals[i].equals("diamond")) {
                d++;
            } else if (minerals[i].equals("iron")) {
                ir++;
            } else {
                s++;
            }

            if (i % 5 == 4 || i == minerals.length - 1) {
                queue.add(new Mineral(d, ir, s));
                d = 0;
                ir = 0;
                s = 0;
            }

            if (queue.size() == picksCount) {
                break;
            }
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            Mineral mineral = queue.poll();
            if (picks[0] > 0) {
                picks[0] = picks[0] - 1;
                answer += mineral.d + mineral.i + mineral.s;
                continue;
            }

            if (picks[1] > 0) {
                picks[1] = picks[1] - 1;
                answer += (mineral.d * 5) + mineral.i + mineral.s;
                continue;
            }

            if (picks[2] > 0) {
                picks[2] = picks[2] - 1;
                answer += (mineral.d * 25) + (mineral.i * 5) + mineral.s;
            }
        }

        return answer;
    }

    /**
     * 1
     * 1
     * 1
     *
     * s = 5
     *
     */
    static class Mineral implements Comparable<Mineral> {
        int d;
        int i;
        int s;

        public Mineral(int d, int i, int s) {
            this.d = d;
            this.i = i;
            this.s = s;
        }

        @Override
        public int compareTo(Mineral o) {
            if (this.d != o.d) {
                return Integer.compare(o.d, this.d);
            } else if (this.i != o.i) {
                return Integer.compare(o.i, this.i);
            } else {
                return Integer.compare(o.s, this.s);
            }
        }
    }
}

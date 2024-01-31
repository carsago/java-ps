package programmers.level2;

public class 연속된부분수열의합 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println("a = " + solution(a, 7));
    }

    public static int[] solution(int[] sequence, int k) {
        int startIdx = 0;
        int endIdx = Integer.MAX_VALUE;
        int sum = 0;
        int length = Integer.MAX_VALUE;
        int[] answer = new int[2];
        for (int i = 0; i < sequence.length; i++) {
            int value = sequence[i];
            sum += value;

            if (sum < k) {
                continue;
            }

            while (sum > k && startIdx < endIdx) {
                sum -= sequence[startIdx];
                startIdx++;
            }

            if (sum == k) {
                endIdx = i;
                if (length > endIdx - startIdx) {
                    length = endIdx - startIdx;
                    answer[0] = startIdx;
                    answer[1] = endIdx;
                }
            }
        }
        return answer;
    }
}

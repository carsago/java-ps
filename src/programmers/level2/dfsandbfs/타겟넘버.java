package programmers.level2.dfsandbfs;


public class 타겟넘버 {

    static int answer = 0;

    public int solution(int[] numbers, int target) {
        fun(numbers, 0, 0, target);
        return answer;
    }

    private void fun(int[] numbers, int value, int idx, int target) {
        if (idx == numbers.length) {
            if (value == target) {
                answer++;
            }
            return;
        }

        fun(numbers, value + numbers[idx], idx + 1, target);
        fun(numbers, value - numbers[idx], idx + 1, target);
    }
}

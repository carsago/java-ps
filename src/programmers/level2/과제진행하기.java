package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class 과제진행하기 {

    public static void main(String[] args) {
        String[][] strings = {{"A", "11:50", "30"}, {"B", "13:00", "20"}, {"C", "13:10", "30"}};
        solution(strings);
    }

    public static String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        Stack<Mission> stack = new Stack<>();
        Queue<Mission> queue = new LinkedList<>();

        Arrays.sort(plans, Comparator.comparing(arr -> arr[1]));
        for (int i = 0; i < plans.length; i++) {
            String[] a = plans[i][1].split(":");
            int time = Integer.parseInt(a[0]) * 60 + Integer.parseInt(a[1]);
            queue.add(new Mission(plans[i][0], time , Integer.parseInt(plans[i][2])));
        }

        int now = queue.peek().time;

        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                answer.add(queue.poll().name);

                while (!stack.isEmpty()) {
                    answer.add(stack.pop().name);
                }
                break;
            }
            Mission mission = queue.poll();
            Mission nextMission = queue.peek();
            if (now + mission.min > nextMission.time) {
                stack.push(mission);
                mission.min = mission.min - (nextMission.time - now);
                now = nextMission.time;
            } else {
                answer.add(mission.name);
                now = now + mission.min;
                while (!stack.isEmpty()) {
                    Mission sMission = stack.pop();
                    if (now + sMission.min > nextMission.time) {
                        stack.push(sMission);
                        sMission.min = sMission.min - (nextMission.time - now);
                        now = nextMission.time;
                        break;
                    }
                    answer.add(sMission.name);
                    now = now + sMission.min;
                }
                now = nextMission.time;

            }
        }

        return answer.toArray(new String[answer.size()]);
    }

    static class Mission {
        String name;
        int time;
        int min;

        public Mission(String name, int time, int min) {
            this.name = name;
            this.time = time;
            this.min = min;
        }
    }
}

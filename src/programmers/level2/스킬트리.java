package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class 스킬트리 {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < skill.length(); i++) {
            list.add(skill.charAt(i));
        }

        for (String skillTree : skill_trees) {
            answer += add(list, skillTree);
        }
        return answer;
    }

    private int add(List<Character> list, String skillTree) {
        int skillIdx = 0;
        for (int i = 0; i < skillTree.length(); i++) {
            if (list.contains(skillTree.charAt(i))) {
                if (list.get(skillIdx).equals(skillTree.charAt(i))){
                    skillIdx++;
                } else {
                    return 0;
                }
            }
        }
        return 1;
    }
}

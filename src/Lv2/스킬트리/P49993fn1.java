package Lv2.스킬트리;

import java.util.ArrayList;
import java.util.Arrays;

public class P49993fn1 {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        char[] seq = new char[skill.length()];
        ArrayList<Character> al = new ArrayList<>();
        for (int i = 0; i < skill.length(); i++) {
            seq[i] = skill.charAt(i);
            al.add(skill.charAt(i));
        }

        for (String s : skill_trees) {

            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == seq[count]) {
//                    System.out.println(s.charAt(i) + " " + seq[count]);
                    count++;
                    if (count == skill.length()) {
                        break;
                    }
                } else if (al.contains(s.charAt(i))) {
//                    System.out.println(s.charAt(i) + "가 먼저 나옴");
                    count = -1;
                    break;
                }
            }
            if (count != -1) {
                answer++;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        P49993fn1 T = new P49993fn1();
        System.out.println(T.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

}

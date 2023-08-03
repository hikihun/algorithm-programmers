package Lv1.대충_만든_자판;

import java.util.Arrays;
import java.util.HashMap;

public class P160586 {


    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int cnt = 0;

        HashMap<Character, Integer> hm = new HashMap<>();

        for (String s : keymap) {
            for (int i = 0; i < s.length(); i++) {
                if (hm.get(s.charAt(i)) == null) {
                    hm.put(s.charAt(i), i + 1);
                } else {
                    if (hm.get(s.charAt(i)) > i + 1) {
                        hm.put(s.charAt(i), i + 1);
                    }
                }
            }
        }

        System.out.println(hm);

        System.out.println(hm.get('D'));
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            for (int j = 0; j < target.length(); j++) {
//                -1 바로 리턴 해버려서 에러가발생했음
//                j 를 i로 작성했었음
                if (hm.get(target.charAt(j)) == null) {
                    cnt = -1;
                    break;
                }
                cnt += hm.get(target.charAt(j));
            }
            answer[i] = cnt;
            cnt = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        P160586 T = new P160586();
        System.out.println(Arrays.toString(T.solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"AA"}, new String[]{"B"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"AGZ", "BSSS"}, new String[]{"ASA", "BGZ"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"BC", "CDB"}, new String[]{"BB"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"ABCE"}, new String[]{"ABDE"})));
    }

}

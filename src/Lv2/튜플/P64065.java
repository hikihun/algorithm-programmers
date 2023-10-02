package Lv2.튜플;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class P64065 {
    public int[] solution(String s) {
        int[] answer = {};
        String[] split = s.split("[{,}]");
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (String str : split) {
            if (!str.equals("")) {
                int n = Integer.parseInt(str);
                hm.put(n, hm.getOrDefault(n, 0) + 1);
            }
        }

        int[] count = new int[hm.size() + 1];
        for (int i : hm.keySet()) {
            count[hm.get(i)] = i;
        }

        answer = new int[hm.size()];
        for (int i = count.length - 1; i > 0; i--) {
            answer[count.length - 1 - i] = count[i];
        }


        return answer;
    }

    public static void main(String[] args) {
        P64065 T = new P64065();
        System.out.println(Arrays.toString(T.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(T.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
        System.out.println(Arrays.toString(T.solution("{{20,111},{111}}")));
        System.out.println(Arrays.toString(T.solution("{{123}}")));
        System.out.println(Arrays.toString(T.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }

}

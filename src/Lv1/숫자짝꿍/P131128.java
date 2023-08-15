package Lv1.숫자짝꿍;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class P131128 {

    public String solution(String X, String Y) {
        String answer = "";
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashMap<Integer, Integer> hm2 = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();

        for (String s : X.split("")) {
            int i = Integer.parseInt(s);
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        for (String s : Y.split("")) {
            int i = Integer.parseInt(s);
            hm2.put(i, hm2.getOrDefault(i, 0) + 1);
        }

        for (int i : hm.keySet()) {
            if (hm2.get(i) != null) {
                int cnt = Math.min(hm.get(i), hm2.get(i));
                for (int j = 0; j < cnt; j++) {
                    al.add(i);
                }
            }
        }

        if (al.size() == 0) {
            return "-1";
        }

        al.sort(Collections.reverseOrder());
        for (int i : al) {
            answer += String.valueOf(i);
        }
        answer = String.valueOf(Integer.parseInt(answer));

        return answer;
    }

    public static void main(String[] args) {
        P131128 T = new P131128();
        System.out.println(T.solution("100", "2345"));
        System.out.println(T.solution("100", "203045"));
        System.out.println(T.solution("100", "123450"));
        System.out.println(T.solution(	"12321", "42531"));
        System.out.println(T.solution(	"5525", "1255"));

    }

}

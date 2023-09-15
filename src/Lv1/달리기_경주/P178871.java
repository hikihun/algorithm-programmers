package Lv1.달리기_경주;

import java.util.Arrays;
import java.util.HashMap;

public class P178871 {

    public String[] solution(String[] players, String[] callings) {

        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            hm.put(players[i], i);
        }

        for(String s : callings) {
            String tmp = players[hm.get(s) - 1];
            int t = hm.get(s) - 1;
            players[t] = s;
            players[t + 1] = tmp;
            hm.put(tmp, t + 1);
            hm.put(s, t);
        }

        return players;
    }

    public static void main(String[] args) {
        P178871 T = new P178871();
        System.out.println(Arrays.toString(
            T.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"},
                new String[]{"kai", "kai", "mine", "mine"})));
        System.out.println(Arrays.toString(
            T.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai"})));
    }

}

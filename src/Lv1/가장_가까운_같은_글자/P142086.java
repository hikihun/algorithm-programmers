package Lv1.가장_가까운_같은_글자;

import java.util.Arrays;
import java.util.HashMap;

public class P142086 {

    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                answer[i] = -1;
                map.put(s.charAt(i), i);
            } else {
                answer[i] = i - map.get(s.charAt(i));
                map.put(s.charAt(i), i);
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        P142086 T = new P142086();
        System.out.println(Arrays.toString(T.solution("banana")));
        System.out.println(Arrays.toString(T.solution(	"foobar")));
    }

}

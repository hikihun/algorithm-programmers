package Lv2.귤_고르기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P138476 {

    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Arrays.sort(tangerine);

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0)+1);
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        for(int i : keySet) {
            k -= map.get(i);
            answer++;
            if(k <= 0) return answer;
        }

        return answer;
    }

    public static void main(String[] args) {
        P138476 T = new P138476();
        System.out.println(T.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(T.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(T.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }

}

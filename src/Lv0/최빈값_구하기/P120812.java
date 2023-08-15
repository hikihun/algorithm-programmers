package Lv0.최빈값_구하기;

import java.util.HashMap;
import java.util.Map;

public class P120812 {


    public int solution(int[] array) {
        int answer = 0;
//        int max = 0;
//        int cnt = 0;
//        Map<Integer, Integer> hm = new HashMap<>();
//
//        for(int i : array) {
//            hm.put(i, hm.getOrDefault(i, 0) + 1);
//        }
//
//        for(int i : hm.keySet()) {
//            if(max < hm.get(i)) {
//                max = hm.get(i);
//            }
//        }
//        for(int i : hm.keySet()) {
//            if(max == hm.get(i)) {
//                answer = i;
//                cnt++;
//            }
//        }
//        if(cnt != 1) {
//            return -1;
//        }

        int max = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : array) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        for(int i : hm.keySet()) {
            if(hm.get(i) > max) {
                answer = i;
                max = hm.get(i);
            } else if(hm.get(i) == max) {
                answer = -1;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        P120812 T = new P120812();
        System.out.println(T.solution(new int[]{1, 2, 3, 3, 3, 4}));
        System.out.println(T.solution(new int[]{1, 1, 2, 2}));
        System.out.println(T.solution(new int[]{1}));
    }

}

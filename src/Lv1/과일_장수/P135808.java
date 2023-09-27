package Lv1.과일_장수;

import java.util.Arrays;
import java.util.Collections;

public class P135808 {


    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Integer[] fruit = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(fruit, Collections.reverseOrder());

        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < fruit.length; i++) {
            if (count < m) {
                min = Math.min(min, fruit[i]);
                count++;
            }
            if(count == m) {
                answer += min * m;
                min = Integer.MAX_VALUE;
                count = 0;
            }
        }


        return answer;
    }


    public static void main(String[] args) {
        P135808 T = new P135808();
        System.out.println(T.solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1}));
        System.out.println(T.solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
    }

}

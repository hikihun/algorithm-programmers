package Lv2.H_Index;

import java.util.Arrays;
import java.util.Collections;

public class P42747 {

    public int solution(int[] citations) {
        int answer = 0;
        int h = 0;
        Integer[] c = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(c, Collections.reverseOrder());

        for(int i = c.length; i > 0; i--) {
            h = i;
            int count = 0;
            for(int j = 0; j < c.length; j++) {
                if(h <= c[j]) {
                    count++;
                }
            }
            if(count >= h) {
                answer = Math.max(answer, h);
                break;

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P42747 T = new P42747();
        System.out.println(T.solution(new int[]{3, 0, 6, 1, 5}));
        System.out.println(T.solution(new int[]{100, 100, 100}));
        System.out.println(T.solution(new int[]{0, 0, 0}));
    }

}

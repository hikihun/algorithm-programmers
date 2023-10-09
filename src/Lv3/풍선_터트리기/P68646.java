package Lv3.풍선_터트리기;

import java.util.Arrays;

public class P68646 {

    public int solution(int[] a) {
        int answer = 1;

        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min > a[i]) {
                min = Math.min(min, a[i]);
                System.out.println(min);
                answer++;
            }
        }

        min = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            if (min > a[i]) {
                min = Math.min(min, a[i]);
                answer++;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        P68646 T = new P68646();
        System.out.println(T.solution(new int[]{9, -1, -5}));
        System.out.println(T.solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33}));
    }

}

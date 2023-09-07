package Lv2.호텔_대실;

import java.util.Arrays;

public class P155651 {

    public int solution(String[][] book_time) {
        int answer = 0;
        int[] time = new int[1440];

        for (int i = 0; i < book_time.length; i++) {
            String[] s = book_time[i][0].split(":");
            String[] e = book_time[i][1].split(":");

            int start = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
            int end = Math.min(1440, Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]) + 10);

            for (int j = start; j < end; j++) {
                time[j]++;
            }
        }

        System.out.println(Arrays.toString(time));

        for (int i = 0; i < time.length; i++) {
            answer = Math.max(answer, time[i]);
        }

        return answer;
    }


    public static void main(String[] args) {
        P155651 T = new P155651();
        System.out.println(T.solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));
        System.out.println(T.solution(new String[][]{{"09:10", "10:10"}, {"10:10", "12:20"}}));
        System.out.println(T.solution(new String[][]{{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}}));
    }

}

package Lv2.테이블_해시_함수;

import java.util.Arrays;

public class P147354 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, ((o1, o2) -> o1[col - 1] != o2[col - 1] ? o1[col - 1] - o2[col - 1] : o2[0] - o1[0]));
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int S_i = 0;
            for (int d : data[i]) {
                S_i += (d % (i + 1));
            }
            answer = (answer ^ S_i);
        }

        return answer;
    }

    public static void main(String[] args) {
        P147354 T = new P147354();
        System.out.println(T.solution(new int[][]{{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}}, 2, 2, 3));
    }

}

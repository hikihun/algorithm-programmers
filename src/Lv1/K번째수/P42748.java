package Lv1.K번째수;

import java.util.Arrays;

public class P42748 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int idx = 0;
            int[] tmp = new int[commands[i][1] - commands[i][0] + 1];
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                tmp[idx] = array[j];
                idx++;
            }
            Arrays.sort(tmp);
            for (int j = 0; j < tmp.length; j++) {
                if (j == commands[i][2] - 1) {
                    answer[i] = tmp[j];
                }
            }
        }



        return answer;
    }

    public static void main(String[] args) {
        P42748 T = new P42748();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 5, 2, 6, 3, 7, 4},
            new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));

    }

}

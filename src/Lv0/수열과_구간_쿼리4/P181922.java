package Lv0.수열과_구간_쿼리4;

import java.util.Arrays;

public class P181922 {

    public int[] solution(int[] arr, int[][] queries) {

        for (int i = 0; i < queries.length; i++) {
            int checkNum = queries[i][2];
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (j % checkNum == 0) {
                    arr[j]++;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        P181922 T = new P181922();
        System.out.println(Arrays.toString(
            T.solution(new int[]{0, 1, 2, 4, 3}, new int[][]{{0, 4, 1}, {0, 3, 2}, {0, 3, 3}})));
    }

}

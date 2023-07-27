package Lv0.수열과_구간_쿼리2;

import java.util.Arrays;

public class P181923 {

    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int checkNum = queries[i][2];
            int n = Integer.MAX_VALUE;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (arr[j] > checkNum) {
                    n = Math.min(arr[j], n);
                }
            }
            if (n == Integer.MAX_VALUE) {
                n = -1;
            }
            answer[i] = n;
        }

        return answer;
    }

    public static void main(String[] args) {
        P181923 T = new P181923();
        System.out.println(Arrays.toString(
            T.solution(new int[]{0, 1, 2, 4, 3}, new int[][]{{0, 4, 2}, {0, 3, 2}, {0, 2, 2}})));
    }

}

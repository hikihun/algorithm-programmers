package Lv2.양궁대회;

import java.util.Arrays;
import java.util.HashMap;

public class P92342 {

    int N;
    int max = -1;
    int[] apeach;
    int[] lion = new int[11];
    int[] result = new int[]{-1};

    public int[] solution(int n, int[] info) {
        N = n;
        apeach = info;

        // 무조건 비기는 경우
        if (n == info[0]) {
            return new int[]{-1};
        }

        dfs(0);
        return result;
    }

    public void dfs(int cnt) {

        // dfs 탈출 조건
        if (N == cnt) {
            int apeachScore = 0;
            int lionScore = 0;
            for (int i = 0; i < 11; i++) {
                if(apeach[i] == 0 && lion[i] == 0) continue;
                if (apeach[i] < lion[i]) {
                    lionScore += 10 - i;
                } else {
                    apeachScore += 10 - i;
                }
            }
            if (lionScore > apeachScore) {
                if (lionScore - apeachScore >= max) {
                    result = lion.clone();
                    max = lionScore - apeachScore;
                }
            }
            return;
        }
        for (int i = 0; i < 11 && lion[i] <= apeach[i]; i++) {
            lion[i]++;
            dfs(cnt + 1);
            lion[i]--;
        }


    }


    public static void main(String[] args) {
        P92342 T = new P92342();
        System.out.println(
            Arrays.toString(T.solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0})));
//        System.out.println(
//            Arrays.toString(T.solution(1, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})));
//        System.out.println(
//            Arrays.toString(T.solution(9, new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1})));
        System.out.println(
            Arrays.toString(T.solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3})));
    }

}

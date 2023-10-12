package Lv3.양과_늑대;

import java.util.ArrayList;

public class P92343 {


    static int[] Info;
    static int[][] Edges;
    static boolean[] visit;
    static int result = 0;

    public int solution(int[] info, int[][] edges) {
        Info = info;
        Edges = edges;
        visit = new boolean[info.length];
        dfs(0, 0, 0, visit);

        return result;
    }


    public void dfs(int idx, int sheep, int wolf, boolean[] visit) {

        visit[idx] = true;
        // 처음은 항상 양 이기 때문에 sheep에 count + 1이 된다.
        if (Info[idx] == 0) {
            sheep++;
            if (result < sheep) {
                result = sheep;
            }
        } else {
            wolf++;
        }

        if (sheep <= wolf) {
            return;
        }

        for (int[] edge : Edges) {
            if (visit[edge[0]] && !visit[edge[1]]) {
                boolean[] next = new boolean[visit.length];
                for (int i = 0; i < visit.length; i++) {
                    next[i] = visit[i];
                }

                dfs(edge[1], sheep, wolf, next);
            }
        }

    }



    public static void main(String[] args) {
        P92343 T = new P92343();
        System.out.println(T.solution(new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
            new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5},
                {4, 6}, {8, 9}}));
        System.out.println("===");
        System.out.println(T.solution(new int[]{0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0},
            new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9},
                {9, 10}}));

    }

}

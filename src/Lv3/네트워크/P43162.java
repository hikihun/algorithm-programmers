package Lv3.네트워크;

import java.util.Arrays;

// dfs
public class P43162 {

    static int[][] map;
    static int answer = 0;
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        map = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    map[i][j] = 1;
                }
            }
        }

        for (int[] i : map) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n);
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(int v, int n) {
        visited[v] = true;

        for (int i = 0; i < n; i++) {
            if (!visited[i] && map[v][i] == 1) {
                dfs(i, n);
            }
        }
    }

    public static void main(String[] args) {
        P43162 T = new P43162();
        System.out.println(T.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(T.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

}

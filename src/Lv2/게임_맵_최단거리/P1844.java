package Lv2.게임_맵_최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class P1844 {

    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    boolean[][] visit;
    int n, m;

    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        visit = new boolean[n][m];
        int bfs = bfs(maps, 0, 0);
        System.out.println(bfs);

        return answer;
    }

    public int bfs(int[][] maps, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 1});
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int depth = poll[2];

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || maps[nx][ny] == 0 || visit[nx][ny]) {
                    continue;
                }

                if (nx == n - 1 && ny == m - 1) {
                    return depth + 1;
                } else {
                    visit[nx][ny] = true;
                    q.add(new int[]{nx, ny, depth + 1});
                }
            }

        }
        return -1;

    }

    public static void main(String[] args) {
        P1844 T = new P1844();
        System.out.println(T.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
        System.out.println(T.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
    }

}

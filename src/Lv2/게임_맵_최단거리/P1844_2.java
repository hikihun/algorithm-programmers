package Lv2.게임_맵_최단거리;

import java.util.LinkedList;
import java.util.Queue;

class Point {
    int x;
    int y;
    int depth;

    Point(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}
public class P1844_2 {

    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    boolean[][] visit;
    int[][] map;
    int n, m;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        map = maps;
        visit = new boolean[n][m];
        return bfs(0, 0);
    }

    public int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 1));
        visit[x][y] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            int depth = p.depth;

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 0 || visit[nx][ny]) {
                    continue;
                }

                if (nx == n - 1 && ny == m - 1) {
                    return depth + 1;
                } else {
                    visit[nx][ny] = true;
                    q.add(new Point(nx, ny, depth + 1));
                }
            }

        }
        return -1;

    }

    public static void main(String[] args) {
        P1844_2 T = new P1844_2();
        System.out.println(T.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
        System.out.println(T.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
    }

}

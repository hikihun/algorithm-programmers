package Boj.Gold.적록색약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj10026 {

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int N, count, blindCount;
    static char[][] map;
    static boolean[][] visited, blindVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        blindVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
                if (!blindVisited[i][j]) {
                    blindBfs(i, j);
                    blindCount++;
                }
            }
        }

        System.out.println(count + " " + blindCount);
    }

    public static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;
        char ch = map[r][c];

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cr = poll[0];
            int cc = poll[1];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) {
                    continue;
                }

                if (map[nr][nc] == ch) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }

            }
        }
    }

    public static void blindBfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        blindVisited[r][c] = true;
        char ch = map[r][c];

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cr = poll[0];
            int cc = poll[1];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N || blindVisited[nr][nc]) {
                    continue;
                }

                if (ch == 'R' || ch == 'G') {
                    if (map[nr][nc] == 'R' || map[nr][nc] == 'G') {
                        blindVisited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                } else {
                    if (ch == map[nr][nc]) {
                        blindVisited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }

//                if ((ch == 'R' || ch == 'G') && (map[nr][nc] == 'R' || map[nr][nc] == 'G')) {
//                    blindVisited[nr][nc] = true;
//                    queue.add(new int[]{nr, nc});
//                }

            }
        }
    }

}

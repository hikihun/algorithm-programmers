package Boj.Gold.빙산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2573 {

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static int N, M, div;
    static int[][] map, temp;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        temp = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        boolean check = false;

        while (true) {
            if (year != 0) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (map[i][j] == 0) {
                            continue;
                        }
                        int count = 0;
                        for (int k = 0; k < 4; k++) {
                            int nr = i + dr[k];
                            int nc = j + dc[k];

                            if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] != 0) {
                                continue;
                            }
                            count++;
                        }
                        temp[i][j] = count;
                    }
                }
            }

            // 차 계산
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (temp[i][j] != 0) {
                        map[i][j] = Math.max(map[i][j] - temp[i][j], 0);
                        temp[i][j] = 0;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0 && !visited[i][j]) {
                        bfs(i, j);
                        div++;
                    }
                }
            }

            if (div >= 2) {
                break;
            } else if (div == 0) {
                check = true;
                break;
            }
            div = 0;
            visited = new boolean[N][M];
            year += 1;
        }

        if (!check) {
            System.out.println(year);
        } else {
            System.out.println(0);
        }


    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cr = poll[0];
            int cc = poll[1];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 0) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc});
            }
        }
    }

}

package Boj.Gold.토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7576 {

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int N, M;
    public static int[][] board;
    public static Queue<tomato> q = new LinkedList<>();

    static class tomato{
        int x;
        int y;
        int day;

        public tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    q.add(new tomato(i, j, 0));
                }
            }
        }

        bfs();
    }

    public static void bfs() {
        int day = 0;
        while (!q.isEmpty()) {
            tomato t = q.poll();
            int cx = t.x;
            int cy = t.y;
            day = t.day;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || board[nx][ny] == -1) {
                    continue;
                }

                if (board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    q.add(new tomato(nx, ny, day + 1));
                }
            }
        }

        if (check()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

    public static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

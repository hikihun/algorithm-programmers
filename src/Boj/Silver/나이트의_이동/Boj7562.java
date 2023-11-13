package Boj.Silver.나이트의_이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7562 {
    public static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    public static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int N, startX, startY, targetX, targetY;
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // map 크기
            visited = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            System.out.println(bfs(startX, startY));
        }

    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cx = poll[0];
            int cy = poll[1];
            int move = poll[2];
            if (cx == targetX && cy == targetY) {
                return move;
            }

            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
                    continue;
                }

                if (nx == targetX && ny == targetY) {
                    return move + 1;
                } else {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, move + 1});
                }


            }
        }
        return -1;
    }

}

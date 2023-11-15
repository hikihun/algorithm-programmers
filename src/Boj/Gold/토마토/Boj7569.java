package Boj.Gold.토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7569 {

    public static int[] dx = {1, 0, -1, 0, 0, 0};
    public static int[] dy = {0, 1, 0, -1, 0, 0};
    public static int[] dz = {0, 0, 0, 0, 1, -1};
    public static int M, N, H;
    public static int[][][] box;
    public static boolean[][][] visited;
    public static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        visited = new boolean[H][N][M];
        int zerocount = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k, 0});
                    }
                    if (box[i][j][k] == 0) {
                        zerocount++;
                    }
                }
            }
        }

        if (zerocount == 0) {
            System.out.println(0);
        } else {
            System.out.println(bfs());
        }


//
//        for (int[][] bo : box) {
//            for (int[] b : bo) {
//                System.out.println(Arrays.toString(b));
//            }
//            System.out.println();
//        }
//        System.out.println();



    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int ch = poll[0];
            int cx = poll[1];
            int cy = poll[2];
            int day = poll[3];
            visited[ch][cx][cy] = true;

            for (int i = 0; i < 6; i++) {
                int nh = ch + dz[i];
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nh < 0 || nh >= H || nx < 0 || nx >= N || ny < 0 || ny >= M
                    || visited[nh][nx][ny] || box[nh][nx][ny] == -1) {
                    continue;
                }

                visited[nh][nx][ny] = true;
                box[nh][nx][ny] = day + 1;
                queue.add(new int[]{nh, nx, ny, day + 1});
            }
        }

        int answer = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        return -1;
                    }
                    answer = Math.max(answer, box[i][j][k]);
                }
            }
        }
        return answer;
    }

}

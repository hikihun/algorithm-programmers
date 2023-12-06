package Boj.Gold.로봇_청소기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS
public class Boj14503 {
    // 북 동 남 서
    // 0 1 2 3
    static int[] dr = {-1, 0, 1, 0}; // 행
    static int[] dc = {0, 1, 0, -1}; // 열

    static int[][] map;
    static int N, M, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(R, C, D);
        System.out.println(answer);

    }

    public static void bfs(int r, int c, int d) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c, d});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cr = poll[0];
            int cc = poll[1];
            int cd = poll[2];
            int nCnt = 0;

            if (map[cr][cc] == 0) {
                answer++;
                map[cr][cc] = 2;
            }

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
                    nCnt++;
                }
            }

            if (nCnt > 0) {
                int nd = cd;
                int nr;
                int nc;
                for (int i = 0; i < 4; i++) {
                    // 1. 반시계 방향으로 90도 회전
                    nd = (nd + 3) % 4;
                    nr = cr + dr[nd];
                    nc = cc + dc[nd];

                    // 2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않았다면 전진
                    if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
                        answer++;
                        map[nr][nc] = 2;
                        queue.add(new int[]{nr, nc, nd});
                        break;
                    }
                }
                // 3. 1번으로 돌아감
            } else {
                // 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아감
                int rd = (cd + 2) % 4;
                int nr = cr + dr[rd];
                int nc = cc + dc[rd];

                if (map[nr][nc] == 1) {
                    break;
                }
                // 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춤
                queue.add(new int[]{nr, nc, cd});
            }

        }
    }

}
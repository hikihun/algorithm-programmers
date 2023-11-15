package Boj.Gold.상범_빌딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj6593 {

    static int[] dc = {0, 0, -1, 1, 0, 0};
    static int[] dr = {1, -1, 0, 0, 0, 0};
    static int[] dl = {0, 0, 0, 0, 1, -1};
    static char[][][] map;
    static boolean[][][] visited;
    static int L, R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new char[L][R][C];
            visited = new boolean[L][R][C];
            int time = 0;
            int sL = 0, sR = 0, sC = 0;

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = s.charAt(k);
                        if (map[i][j][k] == 'S') {
                            sL = i;
                            sR = j;
                            sC = k;
                        }
                    }
                }
                br.readLine();
            }

            time = bfs(sL, sR, sC);
            if (time == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + time + " minute(s).");
            }

        }

    }

    public static int bfs(int l, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{l, r, c, 0});
        visited[l][r][c] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curL = poll[0];
            int curR = poll[1];
            int curC = poll[2];
            int depth = poll[3];

            for (int i = 0; i < 6; i++) {
                int nextL = curL + dl[i];
                int nextR = curR + dr[i];
                int nextC = curC + dc[i];

                if (nextL < 0 || nextL >= L || nextR < 0 || nextR >= R || nextC < 0 || nextC >= C
                    || visited[nextL][nextR][nextC] || map[nextL][nextR][nextC] == '#') {
                    continue;
                }

                if (map[nextL][nextR][nextC] == 'E') {
                    return depth + 1;
                }

                visited[nextL][nextR][nextC] = true;
                queue.add(new int[]{nextL, nextR, nextC, depth + 1});
            }
        }

        return -1;
    }

}

package Lv2.빛의_경로_사이클;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P86052 {

    static char[][] map;
    static boolean[][][] visited;
    static int[] dr = {0, 1, 0, -1}; // 우 하 좌 상
    static int[] dc = {1, 0, -1, 0}; // 0 1 2 3
    static int R, C;
    static ArrayList<Integer> list;

    public int[] solution(String[] grid) {
        int[] answer = {};

        list = new ArrayList<>();
        R = grid.length;
        C = grid[0].length();

        map = new char[R][C];
        visited = new boolean[R][C][4];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = grid[i].charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int k = 0; k < 4; k++) {
                    if (!visited[i][j][k]) {
                        list.add(bfs(i, j, k));
                    }
                }
            }
        }

        answer = list.stream().sorted().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public static int bfs(int r, int c, int d) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c, d, 0});
        visited[r][c][d] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cr = poll[0];
            int cc = poll[1];
            int cd = poll[2];
            int depth = poll[3];

            int nr = (cr + dr[cd] + R) % R;
            int nc = (cc + dc[cd] + C) % C;
            int nd = cd;
            if (map[nr][nc] == 'L') {
                nd = (cd - 1 + 4) % 4;
            } else if (map[nr][nc] == 'R') {
                nd = (cd + 1 + 4) % 4;
            }

            if (nr == r && nc == c && nd == d) {
                return depth + 1;
            }

            visited[nr][nc][nd] = true;
            queue.add(new int[]{nr, nc, nd, depth + 1});

        }

        return -1;
    }

    public static void main(String[] args) {
        P86052 T = new P86052();
        System.out.println(Arrays.toString(T.solution(new String[]{"SL", "LR"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"S"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"R", "R"})));

    }

}

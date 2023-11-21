package Lv3.아이템_줍기;

import java.util.LinkedList;
import java.util.Queue;

public class P87694 {

    static int[][] map = new int[51][51];
    static boolean[][] visited = new boolean[51][51];
    static int[] dc = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dr = {0, 0, 1, -1, 1, -1, 1, -1};
    static int C, R;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        // x값, y값의 최댓값 구하기
        for (int[] m : rectangle) {
            R = Math.max(R, m[3]);
            C = Math.max(C, m[2]);
        }
        // 배열의 크기를 두배로 늘림 -> 두배로 안늘리면 안쪽부분에 체크가 안되는 부분이 있음
        R = R * 2 + 2;
        C = C * 2 + 2;
        map = new int[R][C];
        visited = new boolean[R][C];

        for (int[] m : rectangle) {
            for (int i = m[1] * 2; i <= m[3] * 2; i++) {
                for (int j = m[0] * 2; j <= m[2] * 2; j++) {
                    map[i][j] = 1;
                }
            }
        }

        // 직사각형들의 안쪽 부분을 0으로 바꿈
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int count = 0;

                for (int k = 0; k < 8; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == 0) {
                        continue;
                    }

                    if (map[nr][nc] == 1) {
                        count++;
                    }
                }

                if (count == 8) {
                    visited[i][j] = true;
                }

            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visited[i][j]) {
                    map[i][j] = 0;
                }
            }
        }

        // map 출력 코드
//        for (int[] m : map) {
//            System.out.println(Arrays.toString(m));
//        }
//        System.out.println();

        // 2배 커진 map에서 bfs로 거리를 구한 것이기 때문에 결과에 2를 나누어줌
        answer = bfs(characterY * 2, characterX * 2, itemY * 2, itemX * 2) / 2;

        return answer;
    }

    // bfs로 거리 계산
    public static int bfs(int sR, int sC, int tR, int tC) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sR, sC, 0});
        visited[sR][sC] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cr = poll[0];
            int cc = poll[1];
            int dis = poll[2];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc] || map[nr][nc] == 0) {
                    continue;
                }

                if (nr == tR && nc == tC) {
                    return dis + 1;
                }

                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc, dis + 1});
            }

        }
        return -1;
    }



    public static void main(String[] args) {
        P87694 T = new P87694();
        System.out.println(T.solution(new int[][]{{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}}, 1, 3, 7, 8));
        System.out.println(T.solution(new int[][]{{1, 1, 8, 4}, {2, 2, 4, 9}, {3, 6, 9, 8}, {6, 3, 7, 7}}, 9, 7, 6, 1));
        System.out.println(T.solution(new int[][]{{1, 1, 5, 7}}, 1, 1, 4, 7));
        System.out.println(T.solution(new int[][]{{2, 1, 7, 5}, {6, 4, 10, 10}}, 3, 1, 7, 10));
        System.out.println(T.solution(new int[][]{{2, 2, 5, 5}, {1, 3, 6, 4}, {3, 1, 4, 6}}, 1, 4, 6, 3));
    }

}

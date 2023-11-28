package Boj.Silver.미로_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 실버 1
 * 미로 탐색
 */
public class Boj2178 {

    //    static int N;
//    static int M;
//    static int[][] board;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] split = st.nextToken().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }

        Boj2178 T = new Boj2178();
        System.out.println(T.solution(board));

    }

    public int solution(int[][] board) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;

        answer = bfs(board, N, M);
        return answer;
    }

    public int bfs(int[][] board, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int x = point[0];
            int y = point[1];
            int depth = point[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1 || board[nx][ny] == 0
                    || visited[nx][ny]) {
                    continue;
                }

                if (nx == n - 1 && ny == m - 1) {
                    return depth + 1;
                } else {
                    q.add(new int[]{nx, ny, depth + 1});
                    visited[nx][ny] = true;
                }

            }
        }
        return -1;
    }
}

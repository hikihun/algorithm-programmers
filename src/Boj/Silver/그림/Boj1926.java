package Boj.Silver.그림;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 실버 1
 * 그림
 */
public class Boj1926 {

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    boolean[][] visited;
    int max_width = 0;

    public int[] solution(int[][] board) {
        int[] answer = new int[2];
        int n = board.length;
        int m = board[0].length;
        visited = new boolean[n][m];
        int cnt = 0, width = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    cnt++;
                    width = bfs(board, i, j);
                    if (max_width < width) {
                        max_width = width;
                    }
                }
            }
        }
        answer[0] = cnt;
        answer[1] = max_width;
        return answer;
    }

    public int bfs(int[][] board, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        int width = 1;
        while (!q.isEmpty()) {
            int[] d = q.poll();
            visited[d[0]][d[1]] = true;
            for (int i = 0; i < 4; i++) {
                int nx = d[0] + dx[i];
                int ny = d[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m
                    || board[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }
                width += 1;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }

        return width;
    }


    public static void main(String[] args) throws IOException {
        // 입력 코드
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 출력 코드
        Boj1926 T = new Boj1926();
        int[] answer = T.solution(board);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

}

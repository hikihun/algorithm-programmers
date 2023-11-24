package Lv2.가장_큰_정사각형_찾기;

public class P12905 {
    static int[] dr = {-1, -1, 0};
    static int[] dc = {-1, 0, -1};
    static int row, col;
    static int[][] map;

    public int solution(int [][]board) {
        int n = 0;
        map = board;
        row = board.length;
        col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] != 0) {
                    bfs(i, j);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] >= 1) {
                    n = Math.max(n, map[i][j]);
                }
            }
        }

        return n*n;
    }

    public static void bfs(int r, int c) {
        int min = 1001;
        int count = 0;
        for (int i = 0; i < 3; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= row || nc < 0 || nc >= col) {
                continue;
            }
            min = Math.min(min, map[nr][nc]);
            count++;
        }

        if (count == 3) {
            map[r][c] = min + 1;
        }
    }

    public static void main(String[] args) {
        P12905 T = new P12905();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 1}, {1, 1, 1, 1}}));
    }

}

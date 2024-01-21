package Boj.Silver.쿼드트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1992 {

    public static int[][] board;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = tmp.charAt(j) - '0';
            }
        }

        QuadTree(0, 0, N);
        System.out.println(sb);
    }

    public static void QuadTree(int row, int col, int size) {
        if (check(row, col, size)) {
            sb.append(board[row][col]);
            return;
        }

        int newSize = size / 2;

        sb.append("(");
        QuadTree(row, col, newSize);
        QuadTree(row, col + newSize, newSize);
        QuadTree(row + newSize, col, newSize);
        QuadTree(row + newSize, col + newSize, newSize);
        sb.append(")");
    }

    public static boolean check(int row, int col, int size) {
        int color = board[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != board[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

}

package Boj.Silver.Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1차 시도 : 주석 처리된 부분 메모리 초과
 * 2차 시도 : 시간 초과
 */
public class Boj1074 {

    public static int N, r, C, answer;
    public static int cnt = 0;
    public static int num = 0;
    public static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int n = (int) Math.pow(2, N);
        board = new int[n][n];

        partition(0, 0, n);
//        System.out.println(board[r][C]);
        System.out.println(answer);
    }

    public static void partition(int row, int col, int size) {

        if (cnt == N) {
//            board[row][col] = num;
            if (row == r && col == C) {
                answer = num;
            }
            num++;

            return;
        }

        int newSize = size / 2;

        cnt++;
        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
        cnt--;

    }

}

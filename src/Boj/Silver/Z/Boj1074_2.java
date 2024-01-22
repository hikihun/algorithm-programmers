package Boj.Silver.Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1074_2 {

    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int n = (int) Math.pow(2, N);

        find(r, C, n);
        System.out.println(count);
    }

    public static void find(int row, int col, int size) {
        if(size == 1)
            return;

        if (row < size / 2 && col < size / 2) {
            find(row, col, size / 2);
        } else if (row < size / 2 && col >= size / 2) {
            count += size * size / 4;
            find(row, col - size / 2, size / 2);
        } else if (row >= size / 2 && col < size / 2) {
            count += (size * size / 4) * 2;
            find(row - size / 2, col, size / 2);
        } else {
            count += (size * size / 4) * 3;
            find(row - size / 2, col - size / 2, size / 2);
        }

    }

}

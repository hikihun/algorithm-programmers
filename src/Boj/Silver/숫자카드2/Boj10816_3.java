package Boj.Silver.숫자카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj10816_3 {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            binarySearch(i);
        }

    }

    public static int binarySearch(int num) {
        int cnt = 0;
        int left = 0;
        int right = N - 1;

        while (true) {
            int idx = (left + right) / 2;
            int mid = arr[idx];

            if (num < mid) {
                right = idx + 1;
            } else if (num > mid) {
                left = idx - 1;
            } else {
                cnt++;
            }

        }

    }

}

package Boj.Silver.숫자카드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj10815 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 상근이가 갖고있는 숫자카드
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // 주어지는 정수
        int M = Integer.parseInt(br.readLine());
        int[] answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int m = Integer.parseInt(st.nextToken());

            if (binarySearch(m, arr, N)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    public static boolean binarySearch(int num, int[] arr, int N) {
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int idx = (left + right) / 2;
            int mid = arr[idx];

            if (num < mid) {
                right = idx - 1;
            } else if (num > mid) {
                left = idx + 1;
            } else {
                return true;
            }
        }
        return false;
    }

}

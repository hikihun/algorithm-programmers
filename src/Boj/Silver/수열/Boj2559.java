package Boj.Silver.수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2559 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int sum = 0, max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i < K) {
                sum += arr[i];
            }
        }
        max = sum;

        int idx = 0;
        for (int i = K; i < N; i++) {
            sum += (arr[i] - arr[idx]);
            idx++;
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }

}

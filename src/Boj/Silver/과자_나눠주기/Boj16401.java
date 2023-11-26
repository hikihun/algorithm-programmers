package Boj.Silver.과자_나눠주기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj16401 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] snack = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(snack);
        System.out.println(Arrays.toString(snack));


        long left = 1;
        long right = snack[N - 1];

        while (left <= right) {
            int count = 0;
            long mid = (left + right) / 2;

            for (int i = 0; i < N; i++) {
                if(snack[i]>=mid){
                    count += snack[i] / mid;
                }
            }

            if (count >= M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }

}

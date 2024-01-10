package Boj.Silver.로또;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj6603_3 {
        static int K;
        static int[] arr;
        static boolean[] visit;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                K = Integer.parseInt(st.nextToken());

                if (K == 0) {
                    break;
                }

                arr = new int[K];
                visit = new boolean[K];

                for (int i = 0; i < K; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }

                dfs(0, 0);
                System.out.println();
            }

        }

    static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < K; i++) {
                if (visit[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }

        for (int i = start; i < K; i++) {
            visit[i] = true;
            dfs(i + 1, depth + 1);
            visit[i] = false;
        }

    }

}

package Boj.Silver.로또;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj6603_2 {

    static int K;
    static int[] arr, result;
    static boolean[] visit;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            K = Integer.parseInt(st.nextToken());
            if(K == 0){
                break;
            }

            arr = new int[K];
            visit = new boolean[K];
            result = new int[6];

            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);

            System.out.println(sb);
        }
    }

    static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < K; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[depth] = arr[i];
                dfs(i, depth + 1);
                visit[i] = false;
            }
        }
    }
}

package Boj.Silver.근손실;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj18429 {

    static int N, K, answer;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visit = new boolean[N];
        answer = 0;
        dfs(500, 0);
        System.out.println(answer);
    }

    public static void dfs(int sum, int cnt){
        if(cnt == N){
            answer++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visit[i] && sum + arr[i] - K >= 500) {
                visit[i] = true;
                dfs(sum + arr[i] - K, cnt + 1);
                visit[i] = false;
            }
        }
    }

}

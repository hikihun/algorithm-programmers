package Boj.Silver.숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {

    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

        bfs(N, K);
    }

    public static void bfs(int N, int K) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N, 0});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int m = poll[0];
            int time = poll[1];

            if (m == K) {
                System.out.println(time);
                break;
            }

            if (m + 1 < visited.length && !visited[m + 1]) {
                visited[m + 1] = true;
                q.add(new int[]{m + 1, time + 1});
            }
            if (m - 1 >= 0 && !visited[m - 1]) {
                visited[m - 1] = true;
                q.add(new int[]{m - 1, time + 1});
            }
            if (m * 2 < visited.length && !visited[m * 2]) {
                visited[m * 2] = true;
                q.add(new int[]{m * 2, time + 1});
            }

        }

    }

}

package Boj.Silver.촌수계산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2644 {

    public static int[][] graph;
    public static boolean[] visited;
    public static int V, E, S, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        graph = new int[V + 1][V + 1];
        visited = new boolean[V + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());

            graph[V1][V2] = 1;
            graph[V2][V1] = 1;
        }

        System.out.println(bfs(S));

    }

    public static int bfs(int s) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s, 0});
        visited[s] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int n = p[0];
            int depth = p[1];

            if (n == T) {
                return depth;
            }

            for (int i = 1; i < V + 1; i++) {
                if (graph[n][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(new int[]{i, depth + 1});
                }
            }
        }

        return -1;
    }

}

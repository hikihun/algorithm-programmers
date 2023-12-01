package Boj.Silver.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1260 {

    public static int[][] graph;
    public static boolean[] visited;
    public static int N, M, V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

//        for (int[] g : graph) {
//            System.out.println(Arrays.toString(g));
//        }
//        System.out.println();

        dfs(V);
        System.out.println();
        visited = new boolean[N + 1];
        bfs(V);

    }

    public static void dfs(int s) {
        visited[s] = true;
        System.out.print(s + " ");

        if (s == graph.length) {
            return;
        }
        for (int i = 1; i < N + 1; i++) {
            if (graph[i][s] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int s) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        sb.append(s).append(" ");
        visited[s] = true;

        while (!q.isEmpty()) {
            int poll = q.poll();

            for (int i = 1; i < N + 1; i++) {
                if (graph[i][poll] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }
        System.out.println(sb);
    }

}

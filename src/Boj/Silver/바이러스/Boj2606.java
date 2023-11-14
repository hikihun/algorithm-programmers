package Boj.Silver.바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2606 {

    public static ArrayList<ArrayList<Integer>> al = new ArrayList<>();
    public static boolean[] visited;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        visited = new boolean[V + 1];

        for (int i = 0; i <= V; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            al.add(tmp);
        }
        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());
            al.get(V1).add(V2);
            al.get(V2).add(V1);
        }

        bfs(1);
        System.out.println(answer);
    }

    public static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;

        while (!q.isEmpty()) {
            int n = q.poll();
            int size = al.get(n).size();
            for (int j = 0; j < size; j++) {
                if (!visited[al.get(n).get(j)]) {
                    answer++;
                    q.add(al.get(n).get(j));
                    visited[al.get(n).get(j)] = true;
                }
            }
        }
    }

}

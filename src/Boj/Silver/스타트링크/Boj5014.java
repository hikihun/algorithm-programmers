package Boj.Silver.스타트링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj5014 {

    public static int F, S, G, U, D;
    public static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        visited = new int[F + 1];

        bfs(S);

    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int n = queue.poll();

            if (n == G) {
                System.out.println(visited[n] - 1);
                break;
            }

            if (n + U <= F && visited[n + U] == 0) {
                visited[n + U] = visited[n] + 1;
                queue.add(n + U);
            }
            if (n - D > 0 && visited[n - D] == 0) {
                visited[n - D] = visited[n] + 1;
                queue.add(n - D);
            }

        }

        if (visited[G] == 0) {
            System.out.println("use the stairs");
        }
    }

}

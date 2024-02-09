package Boj.Gold.불;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj4179 {

    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Node> queue = new LinkedList<>();
    static Node jihoon; // 지훈이 위치, 타입, 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'J') {
                    if (i == 0 || j == 0 || i == R - 1 || j == C - 1) {
                        System.out.println(1);
                        return;
                    }

                    map[i][j] = '.';
                    jihoon = new Node(i, j, 0, 0);
                } else if (map[i][j] == 'F') {
                    queue.add(new Node(i, j, 1, 0));
                }
            }
        }

        bfs();
    }

    public static void bfs() {
        queue.add(jihoon);
        visited[jihoon.x][jihoon.y] = true;

        while(!queue.isEmpty()) {
            Node p = queue.poll();

            int curX = p.x;
            int curY = p.y;
            int cnt = p.cnt;

            // 가장자리 && 지훈(type == 0)
            if((curX == 0 || curY == 0 || curX == R-1 || curY == C-1) && p.type == 0) {
                System.out.println(cnt + 1);
                return;
            }

            for(int t=0; t<4; t++) {
                int nx = curX + dx[t];
                int ny = curY + dy[t];

                // 큐에 안 넣어도 되는 조건
                if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == '#'
                    || map[nx][ny] == 'F') {
                    continue;
                }

                if(p.type == 0 && !visited[nx][ny]) { // 지훈이
                    queue.add(new Node(nx, ny, 0, cnt + 1));
                    visited[nx][ny] = true;
                } else { // 불
                    queue.add(new Node(nx, ny, 1, cnt + 1));
                    map[nx][ny] = 'F';
                }
            }

        }

        System.out.println("IMPOSSIBLE");
    }

    static class Node {
        int x, y;
        int type; //0: 지훈, 1: 불
        int cnt;

        Node(int x, int y, int type, int cnt){
            this.x = x;
            this.y = y;
            this.type = type;
            this.cnt = cnt;
        }
    }
}

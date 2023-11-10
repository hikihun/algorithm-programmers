package Lv2.미로_탈출;

import java.util.LinkedList;
import java.util.Queue;

public class P159993 {

    char[][] map;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    public int solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];

        for (int i = 0; i < map.length; i++) {
            char[] arr = maps[i].toCharArray();
            for (int j = 0; j < arr.length; j++) {
                map[i][j] = arr[j];
                if (arr[j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (arr[j] == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                } else if (arr[j] == 'E') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        int startToLever = bfs(start, lever);
        int leverToEnd = bfs(lever, end);
        if (startToLever == -1 || leverToEnd == -1) {
            return -1;
        }
        return startToLever + leverToEnd;
    }

    public int bfs(int[] start, int[] end) {
        boolean[][] visited = new boolean[map.length][map[0].length];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            int depth = p[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length
                    || map[nx][ny] == 'X' || visited[nx][ny]) {
                    continue;
                }

                if (nx == end[0] && ny == end[1]) {
                    return depth + 1;
                } else {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, depth + 1});
                }

            }

        }

        return -1;
    }

    public static void main(String[] args) {
        P159993 T = new P159993();

        System.out.println(T.solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"}));
        System.out.println(T.solution(new String[]{"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"}));

    }

}

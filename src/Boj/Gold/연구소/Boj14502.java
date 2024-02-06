package Boj.Gold.연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14502 {

    private static int N, M;
    private static int maxSafeArea = Integer.MIN_VALUE;
    private static int[][] rooms;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        rooms = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                rooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        createWall(0);

        System.out.println(maxSafeArea);
    }

    private static void createWall(int wall) {
        if (wall == 3) {
            countSafeArea();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (rooms[i][j] == 0) {
                    rooms[i][j] = 1;
                    createWall(wall+1);
                    rooms[i][j] = 0;
                }
            }
        }
    }

    private static void countSafeArea() {
        int[][] copyRooms = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyRooms[i] = Arrays.copyOfRange(rooms[i], 0, M);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyRooms[i][j] == 2) {
                    virus(copyRooms, i, j);
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyRooms[i][j] == 0) {
                    cnt++;
                }
            }
        }

        maxSafeArea = Math.max(maxSafeArea, cnt);
    }

    private static void virus(int[][] copyRooms, int r, int c) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        Queue<int[]> positions = new LinkedList<>();

        positions.add(new int[]{r, c});

        while(!positions.isEmpty()) {
            int[] cur = positions.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if (checkIndex(nr, nc) && copyRooms[nr][nc] == 0) {
                    copyRooms[nr][nc] = 3;
                    positions.add(new int[]{nr, nc});
                }
            }
        }
    }

    private static boolean checkIndex(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

}

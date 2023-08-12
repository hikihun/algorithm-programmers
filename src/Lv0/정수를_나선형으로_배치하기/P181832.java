package Lv0.정수를_나선형으로_배치하기;


import java.util.Arrays;

public class P181832 {

    public int[][] solution(int n) {
        int[][] answer = new int[n][n];

        // 우 하 좌 상
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0, start = 1, idx = 0;
        answer[x][y] = start;

        while (start < n * n) {
            int nx = x + dx[idx];
            int ny = y + dy[idx];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || answer[ny][nx] > 0) {
                idx++;
                if (idx > 3) {
                    idx = 0;
                }
                nx = x + dx[idx];
                ny = y + dy[idx];
            }
            start++;
            answer[ny][nx] = start;
            x = nx;
            y = ny;
        }

//        for (int[] arr : answer) {
//            System.out.println(Arrays.toString(arr));
//        }

        return answer;
    }

    public static void main(String[] args) {
        P181832 T = new P181832();
        T.solution(4);
        System.out.println();
        T.solution(5);
//        System.out.println(Arrays.toString(T.solution(4)));
//        System.out.println(Arrays.toString(T.solution(5)));
    }
}

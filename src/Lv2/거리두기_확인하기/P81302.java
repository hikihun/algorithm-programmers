package Lv2.거리두기_확인하기;

import java.util.ArrayList;
import java.util.Arrays;

public class P81302 {

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer, 1);
        ArrayList<char[][]> m = new ArrayList<>();
        ArrayList<int[][]> mp = new ArrayList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (String[] place : places) {
            char[][] map = new char[5][5];
            int[][] map_point = new int[5][5];
            for (int i = 0; i < 5; i++) {
//                map[i] = place[i].toCharArray();
                for (int j = 0; j < 5; j++) {
                    map[i][j] = place[i].charAt(j);
                    if (place[i].charAt(j) == 'P') {
                        map_point[i][j] -= 1;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];

                            if (nx < 0 || nx > 4 || ny < 0 || ny > 4) {
                                continue;
                            }
                            map_point[nx][ny] -= 1;
                        }
                    } else if (place[i].charAt(j) == 'X') {
                        map_point[i][j] += 3;
                    }
                }
            }
            m.add(map);
            mp.add(map_point);
        }

        for (int i = 0; i < mp.size(); i++) {
            for (int j = 0; j < mp.get(i).length; j++) {
                for (int k = 0; k < mp.get(i)[j].length; k++) {
//                    System.out.print(mp.get(i)[j][k] + " ");
                    if (mp.get(i)[j][k] <= -2) {
                        answer[i] = 0;
                        break;
                    }
                }
            }
        }

        return answer;
    }



    public static void main(String[] args) {
        P81302 T = new P81302();
        System.out.println(Arrays.toString(T.solution(
            new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})));

        System.out.println(Arrays.toString(T.solution(
            new String[][]{{"PPOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "PXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})));

    }

}

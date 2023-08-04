package Lv1.바탕화면_정리;

import java.util.Arrays;

public class P161990 {

    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        char[][] map = new char[wallpaper.length][wallpaper[0].length()];
        int start = 51, end = 0, min = 51, max = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                map[i][j] = wallpaper[i].charAt(j);
                if (wallpaper[i].charAt(j) == '#') {
                    min = Math.min(min, j);
                    max = Math.max(max, j);
                    start = Math.min(start, i);
                    end = Math.max(end, i);
                }
            }

        }

        answer[0] = start;
        answer[1] = min;
        answer[2] = end + 1;
        answer[3] = max + 1;

        return answer;
    }

    public static void main(String[] args) {
        P161990 T = new P161990();
        System.out.println(Arrays.toString(T.solution(new String[]{".#...", "..#..", "...#."})));
        System.out.println(Arrays.toString(T.solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."})));
        System.out.println(Arrays.toString(T.solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."})));
        System.out.println(Arrays.toString(T.solution(new String[]{"..", "#."})));
    }
}

package Lv2.무인도_여행;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P154540 {

    static int sum = 0;

    public int[] solution(String[] maps) {
        int[] answer = {};
        ArrayList<Integer> al = new ArrayList<>();
        char[][] map = new char[maps.length][maps[0].length()];
        boolean[][] check = new boolean[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                dfs(map, check, i, j);
                if (sum > 0) {
                    System.out.println(sum);
                    al.add(sum);
                    sum = 0;
                }
            }
        }

        Collections.sort(al);
        answer = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            answer[i] = al.get(i);
        }

        return answer;
    }

    public void dfs(char[][] map, boolean[][] check, int x, int y) {
        if (x < 0 || y < 0 || x >= map.length || y >= map[0].length || map[x][y] == 'X' || check[x][y]) {
            return;
        } else {
            check[x][y] = true;
            sum += map[x][y] - '0';
        }
        dfs(map, check, x - 1, y);
        dfs(map, check, x + 1, y);
        dfs(map, check, x, y - 1);
        dfs(map, check, x, y + 1);
    }


    public static void main(String[] args) {
        P154540 T = new P154540();
        System.out.println(Arrays.toString(T.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"XXX", "XXX", "XXX"})));
    }

}

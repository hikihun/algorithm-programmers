package Lv3.여행경로;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P43164 {

    static ArrayList<String> list;
    static boolean[] visited;

    public String[] solution(String[][] tickets) {
        list = new ArrayList<>();
        visited = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(list);
        return list.get(0).split(" ");
    }

    public static void dfs(int depth, String now, String path, String[][] tickets) {
        if (depth == tickets.length) {
            list.add(path);
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && now.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        P43164 T = new P43164();
        System.out.println(Arrays.toString(T.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
        System.out.println(Arrays.toString(T.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}})));
        System.out.println(Arrays.toString(T.solution(new String[][]{{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}})));
//        System.out.println(Arrays.toString(T.solution(new String[][]{{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "ICN"}, {"AAA", "ICN"}})));
//        System.out.println(Arrays.toString(T.solution(new String[][]{{"ICN", "AAA"}, {"AAA", "BBB"}, {"AAA", "CCC"}, {"CCC", "AAA"}, {"BBB", "DDD"}})));
    }

}

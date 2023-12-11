package Lv2.혼자_놀기의_달인;

import java.util.ArrayList;

public class P131130 {

    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;

    public int solution(int[] cards) {
        int N = cards.length;
        visited = new boolean[N];
        list = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                ArrayList<Integer> al = new ArrayList<>();
                dfs(i, cards, al);
            }
        }

        if (list.size() == 1) {
            return 0;
        }
        list.sort((o1, o2) -> o2.size() - o1.size());
        return list.get(0).size() * list.get(1).size();
    }

    public void dfs(int idx, int[] cards, ArrayList<Integer> al) {
        if (visited[idx]) {
            list.add(al);
            return;
        }

        visited[idx] = true;
        al.add(cards[idx]);
        dfs(cards[idx] - 1, cards, al);
    }

    public static void main(String[] args) {
        P131130 T = new P131130();
        System.out.println(T.solution(new int[]{8, 6, 3, 7, 2, 5, 1, 4}));

    }

}

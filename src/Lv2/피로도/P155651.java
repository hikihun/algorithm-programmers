package Lv2.피로도;

public class P155651 {

    static int answer = 0;
    static boolean[] check;
    public int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }

    public void dfs(int k, int[][] dungeons, int cnt) {
        answer = Math.max(answer, cnt);
        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0] && !check[i]) {
                check[i] = true;
                dfs(k - dungeons[i][1], dungeons, cnt+1);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        P155651 T = new P155651();
        System.out.println(T.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));

    }

}

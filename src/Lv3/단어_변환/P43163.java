package Lv3.단어_변환;

public class P43163 {

    static boolean[] visited;
    static int answer = 0;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);
        return answer;
    }

    public static void dfs(String begin, String target, String[] words, int cnt) {

        if (begin.equals(target)) {
            answer = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }

            int eCnt = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    eCnt++;
                }
            }

            if (eCnt == begin.length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        P43163 T = new P43163();
        System.out.println(T.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(T.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

}

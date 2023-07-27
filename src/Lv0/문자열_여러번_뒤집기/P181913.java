package Lv0.문자열_여러번_뒤집기;

public class P181913 {

    public String solution(String my_string, int[][] queries) {
        StringBuilder answer = new StringBuilder(my_string);
        for (int i = 0; i < queries.length; i++) {
            String tmp = answer.substring(queries[i][0], queries[i][1] + 1);
            StringBuilder sb = new StringBuilder(tmp);

            answer.replace(queries[i][0], queries[i][1] + 1, sb.reverse().toString());
        }
        return answer.toString();

    }

    public static void main(String[] args) {
        P181913 T = new P181913();
        System.out.println(T.solution("rermgorpsam", new int[][]{{2, 3}, {0, 7}, {5, 9}, {6, 10}}));
        System.out.println(T.solution("new", new int[][]{{1, 2}}));

    }

}

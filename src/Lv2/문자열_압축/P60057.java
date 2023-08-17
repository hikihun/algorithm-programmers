package Lv2.문자열_압축;

public class P60057 {

    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            String cur = s.substring(0, i);
            String tar = "";
            StringBuilder sb = new StringBuilder();
            int cnt = 1;

            for (int j = i; j <= s.length(); j += i) {
                if (j + i > s.length()) {
                    tar = s.substring(j);
                } else {
                    tar = s.substring(j, j + i);
                }

                if (cur.equals(tar)) {
                    cnt++;
                } else {
                    if (cnt > 1) {
                        sb.append(cnt).append(cur);
                        cur = tar;
                        cnt = 1;
                    } else {
                        sb.append(cur);
                        cur = tar;
                    }
                }

            }

            if (cnt > 1) {
                sb.append(cnt);
            }
            sb.append(tar);

            answer = Math.min(answer, sb.toString().length());
        }

        return answer;
    }

    public static void main(String[] args) {
        P60057 T = new P60057();
        System.out.println(T.solution("aabbaccc"));
        System.out.println(T.solution("ababcdcdababcdcd"));
        System.out.println(T.solution("abcabcdede"));
        System.out.println(T.solution(	"abcabcabcabcdededededede"));
        System.out.println(T.solution(	"xababcdcdababcdcd"));
    }

}

package Lv2.모음사전;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class P84512 {

    static char[] c = new char[]{'A', 'E', 'I', 'O', 'U'};
    static HashSet<String> set = new HashSet<>();
    public int solution(String word) {
        dfs("", 0);
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return list.indexOf(word);
    }

    public static void dfs(String str, int depth) {
        if (depth == 6) {
            return;
        }

        for (int i = 0; i < 5; i++) {
            set.add(str);
            dfs(str + c[i], depth + 1);
        }
    }

    public static void main(String[] args) {
        P84512 T = new P84512();
        System.out.println(T.solution("AAAAE"));
        System.out.println(T.solution("AAAE"));
        System.out.println(T.solution("I"));
        System.out.println(T.solution("EIO"));
    }

}

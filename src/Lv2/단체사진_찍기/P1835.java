package Lv2.단체사진_찍기;

import java.util.Stack;

public class P1835 {

    int answer = 0;
    char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    String[] data;
    boolean[] visited = new boolean[8];
    Stack<Character> stack = new Stack<>();

    public int solution(int n, String[] d) {
        data = d;
        dfs(0);
        return answer;
    }

    public void dfs(int depth) {
        if (depth == 8) {
            if (check(stack)) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            stack.add(friends[i]);
            dfs(depth + 1);
            stack.pop();
            visited[i] = false;
        }
    }

    public boolean check(Stack<Character> stack) {
        for (String d : data) {
            char c1 = d.charAt(0);
            char c2 = d.charAt(2);
            char cal = d.charAt(3);
            int target = d.charAt(4) - '0';

            int i1 = stack.search(c1);
            int i2 = stack.search(c2);

//            System.out.println(c1 + " " + c2 + " " + cal + " " + target + " " + i1 + " " + i2);

            if (cal == '=') {
                if (!(Math.abs(i1 - i2) == target + 1)) {
                    return false;
                }
            } else if (cal == '>') {
                if (!(Math.abs(i1 - i2) > target + 1)) {
                    return false;
                }
            } else if (cal == '<') {
                if (!(Math.abs(i1 - i2) < target + 1)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        P1835 T = new P1835();
        System.out.println(T.solution(2, new String[]{"N~F=0", "R~T>2"}));
        System.out.println(T.solution(2, new String[]{"M~C<2", "C~M>1"}));
    }

}

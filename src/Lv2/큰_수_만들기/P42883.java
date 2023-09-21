package Lv2.큰_수_만들기;

import java.util.Stack;

public class P42883 {

    public String solution(String number, int k) {
        String answer = "";
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();

        for (String s : number.split("")) {
            while (true) {
                if (stack.isEmpty() || stack.peek() >= Integer.parseInt(s) || cnt >= k) {
                    stack.push(Integer.parseInt(s));
                    break;
                } else {
                    stack.pop();
                    cnt++;
                }
            }
        }
        while (cnt != k) {
            stack.pop();
            cnt++;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(String.valueOf(stack.pop()));
        }
        answer = sb.reverse().toString();
        return answer;
    }

    public static void main(String[] args) {
        P42883 T = new P42883();
        System.out.println(T.solution("1924", 2));
        System.out.println(T.solution("1231234", 3));
        System.out.println(T.solution("4177252841", 4));
    }

}

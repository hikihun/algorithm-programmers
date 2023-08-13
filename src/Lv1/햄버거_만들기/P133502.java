package Lv1.햄버거_만들기;

import java.util.Stack;

public class P133502 {


    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i : ingredient) {
            stack.add(i);

            if (stack.size() >= 4) {
                if (stack.get(stack.size() - 4) == 1 && stack.get(stack.size() - 3) == 2
                    && stack.get(stack.size() - 2) == 3 && stack.get(stack.size() - 1) == 1) {
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }


        return answer;
    }


    public static void main(String[] args) {
        P133502 T = new P133502();
        System.out.println(T.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
    }

}

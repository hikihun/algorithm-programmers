package Lv2.택배상자;

import java.util.Stack;

public class P131704 {

    public int solution(int[] order) {
        int answer = 0;
        int op = 0;
        int currentBox = 1;

        Stack<Integer> assistanceBelt = new Stack<>();
        while (op < order.length) {
            if (order[op] > currentBox) {
                assistanceBelt.push(currentBox);
                currentBox++;
            } else if (order[op] == currentBox) {
                answer++;
                op++;
                currentBox++;
            } else {
                while (!assistanceBelt.isEmpty() && order[op] == assistanceBelt.peek()) {
                    assistanceBelt.pop();
                    answer++;
                    op++;
                }
                if (op >= order.length || order[op] < currentBox) break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P131704 T = new P131704();
        System.out.println(T.solution(new int[] {4, 3, 1, 2, 5}));
        System.out.println(T.solution(new int[] {5, 4, 3, 2, 1}));
    }

}

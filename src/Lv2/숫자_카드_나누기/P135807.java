package Lv2.숫자_카드_나누기;

import java.util.Arrays;
import java.util.Stack;

public class P135807 {

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int len = arrayA.length;
        int max = arrayA[0];
        for (int i = 2; i <= max; i++) {
            if (max % i == 0) {
                stack.add(i);
            }
        }

        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            boolean check = true;

            for (int i = 0; i < len; i++) {
                if (arrayA[i] % tmp != 0) {
                    check = false;
                    break;
                }
            }

            for (int i = 0; i < len; i++) {
                if (arrayB[i] % tmp == 0) {
                    check = false;
                    break;
                }
            }

            if (check) {
                answer = tmp;
                break;
            }
        }

        stack.clear();
        max = arrayB[0];
        for (int i = 2; i <= max; i++) {
            if (max % i == 0) {
                stack.add(i);
            }
        }

        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            boolean check = true;

            for (int i = 0; i < len; i++) {
                if (arrayA[i] % tmp == 0) {
                    check = false;
                    break;
                }
            }

            for (int i = 0; i < len; i++) {
                if (arrayB[i] % tmp != 0) {
                    check = false;
                    break;
                }
            }

            if (check) {
                answer = Math.max(answer, tmp);
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P135807 T = new P135807();
        System.out.println(T.solution(new int[]{10, 17}, new int[]{5, 20}));
        System.out.println(T.solution(new int[]{10, 20}, new int[]{5, 17}));
        System.out.println(T.solution(new int[]{14, 35, 119}, new int[]{18, 30, 102}));
    }

}

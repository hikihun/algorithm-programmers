package Lv2.뒤에있는_큰수찾기;

import java.util.Arrays;
import java.util.Stack;

public class P154539 {

    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[numbers.length];

        for(int i=0 ; i<numbers.length ; i++) {
            // 하강 직선일 때는 push
            if(stack.isEmpty() || numbers[i]<numbers[i-1]) {
                stack.push(i);
            } else {
                // 현재값보다 작은 index는 pop하여 현재값으로
                while(!stack.isEmpty() && numbers[stack.peek()]<numbers[i]) {
                    ret[stack.pop()] = numbers[i];
                }
                stack.push(i);
            }
        }
        // 나머지는 -1
        while(!stack.isEmpty()) {
            ret[stack.pop()] = -1;
        }
        return ret;
    }

    public static void main(String[] args) {
        P154539 T = new P154539();
        System.out.println(Arrays.toString(T.solution(new int[]{2, 3, 3, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{9, 1, 5, 3, 6, 2})));

    }

}

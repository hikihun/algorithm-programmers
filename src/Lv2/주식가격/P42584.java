package Lv2.주식가격;

import java.util.Arrays;

public class P42584 {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int second = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    second++;
                } else {
                    if (second == 0) {
                        second = 1;
                    } else {
                        second++;
                    }
                    break;
                }
            }
            answer[i] = second;
        }


        return answer;
    }



    public static void main(String[] args) {
        P42584 T = new P42584();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 2, 3})));

    }

}

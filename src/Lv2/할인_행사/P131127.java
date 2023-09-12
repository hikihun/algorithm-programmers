package Lv2.할인_행사;

import java.util.Arrays;

public class P131127 {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int[] cnt = new int[number.length];

        for (int i = 0; i < discount.length - 9; i++) {
            boolean check = true;
            for (int j = i; j < i + 10; j++) {

                for (int k = 0; k < want.length; k++) {
                    if (discount[j].equals(want[k])) {
                        cnt[k] += 1;
                    }
                }
            }

            for (int k = 0; k < number.length; k++) {
                if (cnt[k] != number[k]) {
                    check = false;
                    break;
                }
            }
            if (check) {
                answer++;
            }
            Arrays.fill(cnt, 0);
        }

        return answer;
    }

    public static void main(String[] args) {
        P131127 T = new P131127();
        System.out.println(T.solution(new String[]{"banana", "apple", "rice", "pork", "pot"},
            new int[]{3, 2, 2, 2, 1},
            new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana",
                "pork", "rice", "pot", "banana", "apple", "banana"}));
        System.out.println(T.solution(new String[]{"apple"}, new int[]{10},
            new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana",
                "banana", "banana", "banana"}));
    }

}

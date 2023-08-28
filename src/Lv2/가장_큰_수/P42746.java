package Lv2.가장_큰_수;

import java.util.Arrays;

public class P42746 {

    public String solution(int[] numbers) {
        String answer = "";

        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (arr[0].equals("0")) {
            return "0";
        }

        for (String s : arr) {
            answer += s;
        }

        return answer;
    }

    public static void main(String[] args) {
        P42746 T = new P42746();
        System.out.println(T.solution(new int[]{6, 10, 2}));
        System.out.println(T.solution(new int[]{3, 30, 34, 5, 9}));

    }

}

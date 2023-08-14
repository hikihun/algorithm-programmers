package Lv1.숫자짝꿍;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class P131128_2 {

    public String solution(String X, String Y) {
        String answer = "";
        int[] x = new int[10];
        int[] y = new int[10];

        for (String s : X.split("")) {
            int i = Integer.parseInt(s);
            x[i]++;
        }
        for (String s : Y.split("")) {
            int i = Integer.parseInt(s);
            y[i]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            int min = Math.min(x[i], y[i]);
            for (int j = 0; j < min; j++) {
                sb.append(String.valueOf(i));
            }
        }

        answer = sb.toString();
        if (answer.equals("")) {
            return "-1";
        } else if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer;
    }

    public static void main(String[] args) {
        P131128_2 T = new P131128_2();
        System.out.println(T.solution("100", "2345"));
        System.out.println(T.solution("100", "203045"));
        System.out.println(T.solution("100", "123450"));
        System.out.println(T.solution(	"12321", "42531"));
        System.out.println(T.solution(	"5525", "1255"));

    }

}

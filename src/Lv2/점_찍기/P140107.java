package Lv2.점_찍기;

import java.util.Arrays;

public class P140107 {


    public long solution(int k, int d) {
        long answer = 0;
        long max = 0;
        for (int i = 0; i <= d; i += k) {
            max = (long) Math.sqrt(d * d - i * i);
            answer += max / k + 1;
        }
        return answer;
    }

    public static void main(String[] args) {

        P140107 T = new P140107();
        System.out.println(T.solution(2, 4));
        System.out.println("===============");
        System.out.println(T.solution(1, 5));

    }

}

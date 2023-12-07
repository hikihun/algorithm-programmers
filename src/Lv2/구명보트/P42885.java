package Lv2.구명보트;

import java.util.Arrays;

public class P42885 {

    public int solution(int[] people, int limit) {
        int answer = 0;
        int idx = 0;
        Arrays.sort(people);

        for (int i = people.length - 1; i >= idx; i--) {
            if (people[idx] + people[i] <= limit) {
                idx++;
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        P42885 T = new P42885();
        System.out.println(T.solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(T.solution(new int[]{70, 80, 50}, 100));
    }

}

package Lv1.모의고사;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P42840 {

    public int[] solution(int[] answers) {
        int[] answer;
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = {0,0,0};
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == a[i%5]) {
                score[0]++;
            }
            if(answers[i] == b[i%8]) {
                score[1]++;
            }
            if(answers[i] == c[i%10]) {
                score[2]++;
            }
        }

        int max = Math.max(score[0], Math.max(score[1], score[2]));

        List<Integer> li = new ArrayList<>();
        for(int i=0; i<score.length; i++) if(max == score[i]) li.add(i+1);

        answer = new int[li.size()];
        for(int i=0; i<li.size(); i++){
            answer[i] = li.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        P42840 T = new P42840();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 2})));
    }

}

package Lv1.완주하지_못한_선수;

import java.util.Arrays;

public class P42576 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }
        if(answer.equals("")) answer = participant[participant.length - 1];


        return answer;
    }

    public static void main(String[] args) {
        P42576 T = new P42576();
        System.out.println(
            T.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));

        System.out.println(T.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
            new String[]{"josipa", "filipa", "marina", "nikola"}));

        System.out.println(T.solution(new String[]{"mislav", "stanko", "mislav", "ana"},
            new String[]{"stanko", "ana", "mislav"}));
    }

}

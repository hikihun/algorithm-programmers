package Lv1.성격_유형_검사하기;

import java.util.HashMap;

public class P118666 {


    public String solution(String[] survey, int[] choices) {
        String answer = "";

        int[] score = {0, 3, 2, 1, 0, 1, 2, 3};
        String[] type = {"R", "T", "C", "F", "J", "M", "A", "N"};
        HashMap<String, Integer> hm = new HashMap<>();
        for (String s : type) {
            hm.put(s, 0);
        }

        for (int i = 0; i < survey.length; i++) {
            String[] split = survey[i].split("");

            if (choices[i] > 3) {
                hm.put(split[1], hm.getOrDefault(split[1], 0) + score[choices[i]]);
            } else {
                hm.put(split[0], hm.getOrDefault(split[0], 0) + score[choices[i]]);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (hm.get("R") >= hm.get("T")) {
            sb.append("R");
        } else {
            sb.append("T");
        }

        if (hm.get("C") >= hm.get("F")) {
            sb.append("C");
        } else {
            sb.append("F");
        }

        if (hm.get("J") >= hm.get("M")) {
            sb.append("J");
        } else {
            sb.append("M");
        }

        if (hm.get("A") >= hm.get("N")) {
            sb.append("A");
        } else {
            sb.append("N");
        }

        answer = sb.toString();


        return answer;
    }


    public static void main(String[] args) {
        P118666 T = new P118666();
        System.out.println(T.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[] {5, 3, 2, 7, 5}));
        System.out.println(T.solution(new String[]{"TR", "RT", "TR"}, new int[] {7, 1, 3}));
    }

}

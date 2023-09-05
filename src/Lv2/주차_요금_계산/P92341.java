package Lv2.주차_요금_계산;

import java.util.Arrays;
import java.util.HashMap;

public class P92341 {

    public int[] solution(int[] fees, String[] records) {

        HashMap<String, String> check = new HashMap<>();
        HashMap<String, Integer> time = new HashMap<>();
        for (String s : records) {
            String[] s1 = s.split(" ");
            if (s1[2].equals("IN")) {
                check.put(s1[1], s1[0]);
            } else if (s1[2].equals("OUT")) {
                String s2 = check.get(s1[1]);
                String[] in = s2.split(":");
                String[] out = s1[0].split(":");

                int hour = Integer.parseInt(out[0]) - Integer.parseInt(in[0]);
                int min = Integer.parseInt(out[1]) - Integer.parseInt(in[1]);
                if (Integer.parseInt(out[1]) < Integer.parseInt(in[1])) {
                    min += 60;
                    hour--;

                }
                time.put(s1[1], time.getOrDefault(s1[1], 0) + hour * 60 + min);
                check.put(s1[1], "0");
            }
        }
        for (String s : check.keySet()) {
            if (!check.get(s).equals("0")) {
                String[] in = check.get(s).split(":");
                int hour = 23 - Integer.parseInt(in[0]);
                int min = 59 - Integer.parseInt(in[1]);
                time.put(s, time.getOrDefault(s, 0) + hour * 60 + min);
            }
        }

        String[] num = new String[time.size()];
        int[] answer = new int[time.size()];
        int idx = 0;
        for (String s : time.keySet()) {
            num[idx] = s;
            idx++;
        }
        Arrays.sort(num);

        for (int i = 0; i < num.length; i++) {
            if (time.get(num[i]) <= fees[0]) {
                answer[i] = fees[1];
            } else {
                answer[i] = fees[1] + ((int)Math.ceil((time.get(num[i]) - fees[0]) / (double)fees[2])) * fees[3];
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        P92341 T = new P92341();
        System.out.println(Arrays.toString(T.solution(new int[]{180, 5000, 10, 600},
            new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
                "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN",
                "23:00 5961 OUT"})));
        System.out.println(Arrays.toString(T.solution(new int[]{120, 0, 60, 591},
            new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT",
                "23:58 3961 IN"})));
    }

}

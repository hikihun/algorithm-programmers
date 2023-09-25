package Lv2.광물_캐기;

import java.util.Arrays;

public class P172927 {

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;


        int use = minerals.length / 5 + 1;
        int pickCnt = picks[0] + picks[1] + picks[2];
        int[][] check = new int[use][3];
        if (use > pickCnt) {
            check = new int[pickCnt][3];
        }

        int idx = 0;
        int cnt = 0;
        for (int i = 0; i < minerals.length; i++) {
            if (minerals[i].equals("diamond")) {
                check[idx][0]++;
                cnt++;
            } else if (minerals[i].equals("iron")) {
                check[idx][1]++;
                cnt++;
            } else {
                check[idx][2]++;
                cnt++;
            }

            if (cnt % 5 == 0) {
                idx++;
            }
            if (idx + 1 > pickCnt) {
                break;
            }
        }

        Arrays.sort(check, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]);
            }
            else {
                return Integer.compare(o2[0], o1[0]);
            }
        });

        for (int i = 0; i < picks[0]; i++) {
            for (int j = 0; j < 3; j++) {
                answer += check[i][j];
            }
            if (i == use - 1) {
                return answer;
            }
        }

        for (int i = picks[0]; i < picks[0] + picks[1]; i++) {
            answer += check[i][0] * 5;
            answer += check[i][1];
            answer += check[i][2];
            if (i == use - 1) {
                return answer;
            }
        }

        for (int i = picks[0] + picks[1]; i < picks[0] + picks[1] + picks[2]; i++) {
            answer += check[i][0] * 25;
            answer += check[i][1] * 5;
            answer += check[i][2];
            if (i == use - 1) {
                return answer;
            }
        }


        return answer;
    }


    public static void main(String[] args) {
        P172927 T = new P172927();
//        System.out.println(T.solution(new int[]{1, 3, 2},
//            new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron",
//                "stone"}));
//
//        System.out.println(T.solution(new int[]{0, 1, 1},
//            new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron",
//                "iron", "iron", "iron", "diamond"}));
//
//        System.out.println(T.solution(new int[]{1, 0, 0},
//            new String[]{"iron", "iron", "iron", "iron", "iron", "iron", "iron", "iron", "iron", "iron", "diamond"}));
//
//        System.out.println(T.solution(new int[]{1, 1, 0},
//            new String[]{"stone", "stone", "iron", "stone", "diamond", "diamond", "diamond", "diamond", "diamond", "diamond"}));

        System.out.println(T.solution(new int[]{0, 1, 1},
            new String[]{"iron", "iron", "stone", "stone", "stone", "iron","iron", "stone"}));
    }

}

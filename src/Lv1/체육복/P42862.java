package Lv1.체육복;

import java.util.ArrayList;
import java.util.Arrays;

public class P42862 {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        ArrayList<Integer> reserveL = new ArrayList<>();
        for (int i : reserve) {
            reserveL.add(i);
        }

        ArrayList<Integer> lostL = new ArrayList<>();
        for (int i : lost) {
            if (reserveL.contains(i)) {
                reserveL.remove(Integer.valueOf(i));
                continue;
            }
            lostL.add(i);
        }

        for (int i : lost) {
            if (reserveL.contains(i - 1)) {
                reserveL.remove(Integer.valueOf(i - 1));
                lostL.remove(Integer.valueOf(i));
                System.out.println(lostL);
                continue;
            } else if (reserveL.contains(i + 1)) {
                reserveL.remove(Integer.valueOf(i + 1));
                lostL.remove(Integer.valueOf(i));
            }
        }

        answer = n - lostL.size();

        return answer;
    }

    public static void main(String[] args) {
        P42862 T = new P42862();
//        System.out.println(T.solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
//        System.out.println(T.solution(5, new int[]{2, 4}, new int[]{3}));
//        System.out.println(T.solution(5, new int[]{4, 2}, new int[]{3, 5}));
//        System.out.println(T.solution(10, new int[]{3, 4, 7, 9}, new int[]{2, 3, 8}));
        System.out.println(T.solution(6, new int[]{1, 2, 3, 4, 6}, new int[]{2, 4, 5, 6}));
    }

}

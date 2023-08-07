package Lv0.전국_대회_선발_고사;

public class P181851 {

    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        int[] arr = {10000, 100, 1};

        for (int i = 0; i < 3; i++) {
            int r = 101;
            int idx = 0;
            for (int j = 0; j < rank.length; j++) {
                if (rank[j] < r && attendance[j]) {
                    r = rank[j];
                    idx = j;
                }
            }
            attendance[idx] = false;
            answer += arr[i] * idx;
        }
        return answer;
    }

    public static void main(String[] args) {
        P181851 T = new P181851();
        System.out.println(T.solution(new int[]{3, 7, 2, 5, 4, 6, 1}, new boolean[]{false, true, true, true, true, false, false}));
        System.out.println(T.solution(new int[]{1, 2, 3}, new boolean[]{true, true, true}));
        System.out.println(T.solution(new int[]{6, 1, 5, 2, 3, 4}, new boolean[]{true, false, true, false, false, true}));
    }

}

package Lv1.덧칠하기;


public class P161989 {

    public int solution(int n, int m, int[] section) {
        int answer = 0;

        int start = section[0];
        answer++;

        for (int i : section) {
            if (start + m > i) {
                continue;
            }

            start = i;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        P161989 T = new P161989();
        System.out.println(T.solution(8, 4, new int[]{2, 3, 6}));
        System.out.println(T.solution(5, 4, new int[]{1, 3}));
        System.out.println(T.solution(4, 1, new int[]{1, 2, 3, 4}));
    }

}

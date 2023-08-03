package Lv1.없는_숫자_더하기;

public class P86051 {
    public int solution(int[] numbers) {
        int answer = -1;
        int sum = 0;
        int[] arr = new int[10];
        for (int i : numbers) {
            arr[i]++;
        }
        for (int i = 1; i <= 9; i++) {
            if (arr[i] == 0) {
                sum += i;
            }
        }

        return sum != 0 ? sum : answer;
    }

    public static void main(String[] args) {
        P86051 T = new P86051();
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0}));
        System.out.println(T.solution(new int[]{5, 8, 4, 0, 6, 7, 9}));
    }

}

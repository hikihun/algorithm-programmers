package Lv1.삼총사;

public class P131705 {

    public int solution(int[] number) {
        int answer = 0;

        for (int i = 0; i < number.length; i++) {
            for (int j = i + 1; j < number.length; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P131705 T = new P131705();
        System.out.println(T.solution(new int[]{-2, 3, 0, 2, -5}));
        System.out.println(T.solution(new int[]{-3, -2, -1, 0, 1, 2, 3}));
        System.out.println(T.solution(new int[]{-1, 1, -1, 1}));

    }

}

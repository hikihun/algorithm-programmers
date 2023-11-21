package Lv2.H_Index;

public class P42747_2 {

    public int solution(int[] citations) {
        int answer = 0;

        for(int i = citations.length; i > 0; i--) {
            int h = i;
            int count = 0;
            for(int j = 0; j < citations.length; j++) {
                if(h <= citations[j]) {
                    count++;
                }
            }
            if(count >= h) {
                answer = Math.max(answer, h);
                break;

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P42747_2 T = new P42747_2();
        System.out.println(T.solution(new int[]{3, 0, 6, 1, 5}));
        System.out.println(T.solution(new int[]{100, 100, 100}));
        System.out.println(T.solution(new int[]{0, 0, 0}));
    }

}

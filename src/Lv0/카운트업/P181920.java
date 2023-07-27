package Lv0.카운트업;

import java.util.Arrays;

public class P181920 {

    public int[] solution(int start, int end) {
        int[] answer = new int[end - start + 1];
        int n = start;
        for (int i = 0; i <= end - start; i++) {
            answer[i] = n;
            n++;
        }

        return answer;

        // 스트림이 코드가 간결하지만 속도 측면에서는 더 느렸다.
        // 코드를 간결하고 가독성 좋게 짜는 것도 중요하지만,
        // 속도 측면에서 보자면 stream보다 반복문을 사용할때가 더 속도가 빠를때가 있으므로, 잘 생각해보고 streamd을 써야할 것 같다.
        // return IntStream.rangeClosed(start, end).toArray();

    }

    public static void main(String[] args) {
        P181920 T = new P181920();
        System.out.println(Arrays.toString(T.solution(3, 10)));
    }
}

package Lv2.더_맵게;

import java.util.PriorityQueue;

public class P42626_2 {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        while (!pq.isEmpty()) {
            int min = pq.poll();
            if (min >= K) {
                break;
            }

            if (!pq.isEmpty()) {
                pq.add(min + (pq.peek() * 2));
                pq.poll();
                answer++;
            } else {
                answer = -1;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P42626_2 T = new P42626_2();
        System.out.println(T.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
        System.out.println(T.solution(new int[]{1, 2, 3, 9, 10, 12}, 1000000));
    }

}

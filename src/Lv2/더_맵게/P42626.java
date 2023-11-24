package Lv2.더_맵게;

import java.util.PriorityQueue;

public class P42626 {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        while (!pq.isEmpty()) {
            if (pq.peek() >= K) {
                break;
            } else {
                if (pq.size() >= 2) {
                    int i1 = pq.poll();
                    int i2 = pq.poll();
                    pq.add(i1 + (i2 * 2));
                    answer++;
                } else {
                    answer = -1;
                    break;
                }

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P42626 T = new P42626();
        System.out.println(T.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
        System.out.println(T.solution(new int[]{1, 2, 3, 9, 10, 12}, 1000000));
    }

}

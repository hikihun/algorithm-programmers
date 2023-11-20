package Lv2.다리를_지나는_트럭;

import java.util.LinkedList;
import java.util.Queue;

public class P42583 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> q = new LinkedList<>();
        int weightSum = 0;
        int idx = 0;
        int time = 0;

        while (true) {

            if (idx < truck_weights.length) {
                weightSum += truck_weights[idx];
                if (q.isEmpty() || (weightSum <= weight && q.size() <= bridge_length)) {
                    q.add(new int[]{truck_weights[idx], time});
                    idx++;
                } else {
                    weightSum -= truck_weights[idx];
                }
            }
            time++;

            if (!q.isEmpty() && time - q.peek()[1] >= bridge_length) {
                int[] poll = q.poll();
                weightSum -= poll[0];
            }

            if (idx == truck_weights.length && q.isEmpty()) {
                break;
            }
        }

        return time + 1;
    }

    public static void main(String[] args) {
        P42583 T = new P42583();
        System.out.println(T.solution(2, 10, new int[]{7, 4, 5, 6}));
//        System.out.println(T.solution(100, 100, new int[]{10}));
//        System.out.println(T.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }

}

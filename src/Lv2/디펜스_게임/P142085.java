package Lv2.디펜스_게임;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class P142085 {

    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int my = n;
        int card = k;
        for (int i = 0; i < enemy.length; i++) {
            my -= enemy[i];
            pq.add(enemy[i]);

            if (my < 0) {
                if (card > 0 && !pq.isEmpty()) {
                    my += pq.poll();
                    card--;
                } else {
                    answer = i;
                    break;
                }
            }
        }

        return answer;
    }



    public static void main(String[] args) {
        P142085 T = new P142085();
        System.out.println(T.solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));
        System.out.println(T.solution(2, 4, new int[]{3, 3, 3, 3}));
    }

}

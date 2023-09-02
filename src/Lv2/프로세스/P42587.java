package Lv2.프로세스;

import java.util.LinkedList;
import java.util.Queue;

public class P42587 {

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
        }

        while (!queue.isEmpty()) {
            int max = 0;

            for (int a : queue) {
                if (a > max) max = a; //현재 queue 중 max값 확인
            }

            if (queue.peek() >= max) { // 첫번째 수가 max value 인 경우
                answer++; //반환된 순서 +1

                if (location == 0) {
                    break;
                } else {
                    queue.poll();
                    location--;
                }
            } else { // max가 아닌 경우
                queue.add(queue.peek()); // 신규 값 insert
                queue.poll(); // 첫번째 값 제거

                if (location == 0) {
                    location = queue.size() - 1;
                } else {
                    location--;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        P42587 T = new P42587();
        System.out.println(T.solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(T.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

}

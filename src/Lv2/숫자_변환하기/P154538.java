package Lv2.숫자_변환하기;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class P154538 {

    public int solution(int x, int y, int n) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(x);
        visited.add(x);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == y) {
                    return count;
                }
                if (cur + n <= y && !visited.contains(cur + n)) {
                    queue.add(cur + n);
                    visited.add(cur + n);
                }
                if (cur * 2 <= y && !visited.contains(cur * 2)) {
                    queue.add(cur * 2);
                    visited.add(cur * 2);
                }
                if (cur * 3 <= y && !visited.contains(cur * 3)) {
                    queue.add(cur * 3);
                    visited.add(cur * 3);
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        P154538 T = new P154538();
        System.out.println(T.solution(10, 40, 5));
        System.out.println(T.solution(10, 40, 30));
        System.out.println(T.solution(2, 5, 4));
    }

}

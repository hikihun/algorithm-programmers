package Boj.Silver.카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2164 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                System.out.println(queue.poll());
                break;
            } else if (queue.size() == 2) {
                queue.poll();
                System.out.println(queue.poll());
                break;
            } else {
                queue.poll();
                queue.add(queue.poll());
            }
        }

    }

}

package Boj.Silver.제로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj10773 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n != 0) {
                stack.push(n);
            } else {
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        System.out.println(answer);
    }

}

package Boj.Gold.탑;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj2493 {

    public static class Top {
        int num;
        int height;

        public Top(int num, int height) {
            this.num = num;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Stack<Top> stack = new Stack<>();


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int h = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                sb.append("0 ");
                stack.push(new Top(i, h));
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        sb.append("0 ");
                        stack.push(new Top(i, h));
                        break;
                    }

                    Top top = stack.peek();

                    if (top.height > h) {
                        sb.append(top.num).append(" ");
                        stack.push(new Top(i, h));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        System.out.println(sb.toString());

    }

}

package Boj.Gold.좋은_수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2661 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs("");
    }

    private static void dfs(String result) {
        if (result.length() == N) {
            System.out.println(result);
            System.exit(0);

        } else {
            for (int i = 1; i <= 3; i++) {
                if (check(result + i)) {
                    dfs(result + i);
                }
            }
        }
    }

    private static boolean check(String s) {
        int length = s.length() / 2;

        for (int i = 1; i <= length; i++) {
            if (s.substring(s.length() - i)
                .equals(s.substring(s.length() - 2 * i, s.length() - i))) {
                return false;
            }
        }

        return true;
    }

}

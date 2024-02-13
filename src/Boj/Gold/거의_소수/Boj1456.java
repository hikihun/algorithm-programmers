package Boj.Gold.거의_소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1456 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long[] number = new long[10000001];
        for (int i = 2; i < number.length; i++) {
            number[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(number.length); i++) {
            if (number[i] == 0) {
                continue;
            }
            for (int j = i + i; j < number.length; j = j + i) {
                number[j] = 0;
            }
        }

        int count = 0;
        for (int i = 2; i < 10000001; i++) {
            if (number[i] != 0) {
                long temp = number[i];
                while ((double) number[i] <= (double) B / (double) temp) {
                    if ((double) number[i] >= (double) A / (double) temp) {
                        count++;
                    }
                    temp = temp * number[i];
                }
            }
        }
        System.out.println(count);
    }

}

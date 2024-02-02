package Boj.Silver.카드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Boj11652 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> hm = new HashMap<>();

        int max = 0;
        long key = 0;
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            hm.put(num, hm.getOrDefault(num, 0) + 1);

            if (hm.get(num) > max) {
                max = hm.get(num);
                key = num;
            } else if (hm.get(num) == max) {
                key = Math.min(key, num);
            }
        }

        System.out.println(key);
    }

}

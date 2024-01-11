package Boj.Silver.회사에_있는_사람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Boj7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashSet<String> hs = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");

            if (str[1].equals("enter")) {
                hs.add(str[0]);
            } else if (str[1].equals("leave")) {
                hs.remove(str[0]);
            }
        }

        List<String> list = new ArrayList<>(hs);
        Collections.sort(list, Collections.reverseOrder());
        for (String s : list) {
            System.out.println(s);
        }
    }

}

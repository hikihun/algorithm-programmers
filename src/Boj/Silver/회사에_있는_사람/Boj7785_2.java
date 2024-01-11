package Boj.Silver.회사에_있는_사람;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Boj7785_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashSet<String> hs = new HashSet<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String type = st.nextToken();

            if (type.equals("enter")) {
                hs.add(name);
            } else if (type.equals("leave")) {
                hs.remove(name);
            }
        }

        List<String> list = new ArrayList<>(hs);
        Collections.sort(list, Collections.reverseOrder());
        for (String s : list) {
            System.out.println(s);
        }
    }

}

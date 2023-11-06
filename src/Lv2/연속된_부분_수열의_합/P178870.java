package Lv2.연속된_부분_수열의_합;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P178870 {

    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<int[]> al = new ArrayList<>();
        int sum = 0;
        int idx = 0;
        int len = 1000000;
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == k) {
                answer[0] = i;
                answer[1] = i;
                break;
            }

            q.add(sequence[i]);
            sum += sequence[i];

            if (sum == k) {
                answer[0] = idx;
                answer[1] = i;
                al.add(new int[]{idx, i});
                len = i - idx;
            }
            if (sum > k) {
                int tmp = 0;
                while (sum > k) {
                    tmp = q.poll();
                    sum -= tmp;
                    idx++;

                    if (sum == k && i - idx < len) {
                        answer[0] = idx;
                        answer[1] = i;
                        al.add(new int[]{idx, i});

                        break;
                    }
                }
            }
        }
        for (int[] a : al) {
            System.out.print(Arrays.toString(a));
        }
        return answer;
    }

    public static void main(String[] args) {
        P178870 T = new P178870();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5)));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 2, 2}, 6)));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 1, 1, 2}, 2)));
    }

}

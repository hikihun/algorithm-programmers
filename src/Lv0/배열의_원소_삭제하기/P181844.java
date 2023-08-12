package Lv0.배열의_원소_삭제하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P181844 {

    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i : arr) {
            al.add(i);
        }
        for (int i : delete_list) {
            al.remove(Integer.valueOf(i));
        }

        int[] answer = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            answer[i] = al.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        P181844 T = new P181844();
        System.out.println(Arrays.toString(T.solution(new int[]{293, 1000, 395, 678, 94}, new int[]{94, 777, 104, 1000, 1, 12})));
        System.out.println(Arrays.toString(T.solution(new int[]{110, 66, 439, 785, 1}, new int[]{377, 823, 119, 43})));
    }

}

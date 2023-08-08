package Lv1.추억점수;

import java.util.HashMap;

public class P176963 {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            hm.put(name[i], yearning[i]);
        }

        for(int i = 0; i < photo.length; i++) {
            int sum = 0;
            for(String s : photo[i]) {
                if(hm.get(s) != null) {
                    sum += hm.get(s);
                }
            }
            answer[i] = sum;
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}

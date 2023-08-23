package Lv2.의상;

import java.util.HashMap;

public class P42578 {

    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> hm = new HashMap<>();
        for (String[] clothe : clothes) {
            hm.put(clothe[1], hm.getOrDefault(clothe[1], 1) + 1);
        }
        System.out.println(hm);

        for (String s : hm.keySet()) {
            answer *= hm.get(s);
        }


        return answer - 1;
    }

    public static void main(String[] args) {
        P42578 T = new P42578();
        System.out.println(T.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(T.solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }

}

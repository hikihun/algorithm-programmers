package Lv2.캐시;

import java.util.LinkedList;

public class P17680 {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        LinkedList<String> cache = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            String s = cities[i].toUpperCase();
            if (cache.remove(s)) {
                answer += 1;
                cache.add(s);
            } else {
                answer += 5;
                if (cache.size() >= cacheSize) {
                    cache.remove(0);
                }
                cache.add(s);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P17680 T = new P17680();
        System.out.println(T.solution(3,
            new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul",
                "NewYork", "LA"}));
        System.out.println(T.solution(3,
            new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo",
                "Seoul"}));
        System.out.println(T.solution(2,
            new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul",
                "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(T.solution(5,
            new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul",
                "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(T.solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(T.solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }

}

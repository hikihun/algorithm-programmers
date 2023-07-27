package Lv0.배열_만들기2;

import java.util.ArrayList;
import java.util.Arrays;

public class P181921 {

    public int[] solution1(int l, int r) {
        int[] answer = {-1};
        // r의 크기가 1000000 이하이기 때문에 시간복잡도는 O(n) 이나 O(nlongn) 으로 풀어야 함
        ArrayList<Integer> al = new ArrayList<>();

        for (int i = l; i <= r; i++) {
            String s = String.valueOf(i);
            if (s.matches("[0|5]{1,}")) {
                al.add(i);
            }
        }
        if (al.size() != 0) {
            answer = al.stream().mapToInt(Integer::intValue).toArray();
        }

        return answer;
    }

    public int[] solution2(int l, int r) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = l; i <= r; i++){
            int tmp = i;
            boolean flag = true;
            while(tmp > 0){
                int t = tmp % 10;
                if(!(t == 0 || t == 5)){
                    flag = false;
                    break;
                }
                tmp = tmp / 10;
            }
            if(flag) al.add(i);
        }

        if(al.size() == 0){
            return new int[]{-1};
        }

//        ArrayList -> Array로 바꿀때 stream으로 바꾸니 시간이 더 걸렸다.
//        앞으로 ArrayList -> Array로 바꿀때는 그냥 반복문을 사용하자.
//        int[] answer = al.stream().mapToInt(i -> i).toArray();
        int[] answer = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            answer[i] = al.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        P181921 T = new P181921();
        System.out.println(Arrays.toString(T.solution2(5, 555)));
        System.out.println(Arrays.toString(T.solution2(10, 20)));
    }
}

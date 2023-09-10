package Lv2.이모티콘_할인행사;

import java.util.Arrays;

public class P150368 {

    static int[] discount = {10, 20, 30, 40};
    static int maxOfSubscribe;
    static int maxOfCost;
    public int[] solution(int[][] users, int[] emoticons) {
        DFS(0, emoticons.length, new int[emoticons.length], users, emoticons);
        return new int[]{maxOfSubscribe, maxOfCost};
    }
    public void DFS(int L, int emoticonsLength, int[] discounts, int[][] users, int[] emoticons){
        if(L == emoticonsLength){
            int subscribe = 0;
            int cost = 0;
            for (int[] user: users){
                int userDiscountRate = user[0];
                int userMaxCost = user[1];
                int sum = 0;
                for (int i = 0; i < emoticons.length; i++){
                    if (discounts[i] >= userDiscountRate){
                        sum += emoticons[i]/100*(100-discounts[i]);
                    }
                }
                if (sum >= userMaxCost)subscribe++;
                else cost += sum;
            }
            if (subscribe > maxOfSubscribe){
                maxOfSubscribe = subscribe;
                maxOfCost = cost;
            }else if (subscribe == maxOfSubscribe){
                maxOfCost = Math.max(maxOfCost, cost);
            }
            return;
        }
        for (int i = 0; i < 4; i++){
            discounts[L] = discount[i];
            DFS(L+1, emoticonsLength, discounts, users, emoticons);
        }
    }




    public static void main(String[] args) {
        P150368 T = new P150368();
        System.out.println(Arrays.toString(
            T.solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000})));

//        System.out.println(Arrays.toString(T.solution(
//            new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200},
//                {32, 6900}}, new int[]{1300, 1500, 1600, 4900})));

    }

}

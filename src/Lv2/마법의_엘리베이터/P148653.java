package Lv2.마법의_엘리베이터;

public class P148653 {

    public int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
//            System.out.println(storey);
            if (storey % 10 < 5) {
                answer += storey % 10;
                storey /= 10;
            } else if (storey % 10 == 5 && storey % 100 / 10 < 5) {
                answer += storey % 10;
                storey /= 10;
            } else {
                answer += (10 - storey % 10);
                storey += 10 - (storey % 10);
                storey /= 10;
            }
        }
//        System.out.println((545 %100)/10);

        return answer;
    }


    public static void main(String[] args) {
        P148653 T = new P148653();
//        System.out.println(T.solution(16));
//        System.out.println(T.solution(2554));
        System.out.println(T.solution(545));
    }

}

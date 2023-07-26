package Lv0;

/**
 * flag에 따라 다른 값 반환하기
 *
 * 문제 설명
 * 두 정수 a, b와 boolean 변수 flag가 매개변수로 주어질 때, flag가 true면 a + b를 false면 a - b를 return 하는 solution 함수를 작성해 주세요.
 *
 * 제한사항
 * -1,000 ≤ a, b ≤ 1,000
 *
 * 입출력 예
 * a	b	flag	result
 * -4	7	true	3
 * -4	7	false	-11
 *
 * 입출력 예
 * 입출력 예 #1
 * 예제 1번에서 flag가 true이므로 a + b = (-4) + 7 = 3을 return 합니다.
 *
 * 입출력 예 #2
 * 예제 2번에서 flag가 false이므로 a - b = (-4) - 7 = -11을 return 합니다.
 */
public class P181933 {

    public int solution(int a, int b, boolean flag) {
        int answer = 0;

        if (flag) {
            answer = a + b;
        } else {
            answer = a - b;
        }

        return answer;
    }

    public static void main(String[] args) {
        P181933 T = new P181933();
        System.out.println(T.solution(-4, 7, true));
        System.out.println(T.solution(-4, 7, false));
    }

}

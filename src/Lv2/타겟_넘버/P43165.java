package Lv2.타겟_넘버;

public class P43165 {

    static int[] arr;
    static int answer = 0;
    static int targetNumber;
    public int solution(int[] numbers, int target) {
        arr = numbers;
        targetNumber = target;
        dfs(0, 0);
        return answer;
    }

    public void dfs(int tmp, int idx) {

        if (idx == arr.length) {
            if (tmp == targetNumber) {
                answer++;
            }
            return;
        }
        dfs(tmp + arr[idx], idx + 1);
        dfs(tmp - arr[idx], idx + 1);
    }

    public static void main(String[] args) {
        P43165 T = new P43165();
        System.out.println(T.solution(new int[]{1, 1, 1, 1, 1}, 3));
        answer = 0;
        System.out.println(T.solution(new int[]{4, 1, 2, 1}, 4));
    }

}

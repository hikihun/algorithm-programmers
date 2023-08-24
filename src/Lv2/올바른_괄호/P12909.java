package Lv2.올바른_괄호;

public class P12909 {

    boolean solution(String s) {
        boolean answer = true;
        int cnt = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                cnt += 1;
            } else {
                if(cnt == 0) {
                    answer = false;
                    break;
                } else {
                    cnt -= 1;
                }
            }
        }
        if(cnt != 0) {
            answer = false;
        }


        return answer;
    }

    public static void main(String[] args) {
        P12909 T = new P12909();
        System.out.println(T.solution("()()"));
        System.out.println(T.solution("(())()"));
        System.out.println(T.solution(	")()("));
        System.out.println(T.solution(	"(()("));

    }

}

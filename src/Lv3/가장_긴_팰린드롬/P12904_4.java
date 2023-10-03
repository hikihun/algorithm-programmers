package Lv3.가장_긴_팰린드롬;

public class P12904_4 {


    public int solution(String s)
    {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            answer = Math.max(answer, getPalindromeSize(s, i - 1, i + 1));
            answer = Math.max(answer, getPalindromeSize(s, i, i + 1));
        }

        return answer;
    }

    private int getPalindromeSize(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        while (right == s.length() && left >= 0 && s.charAt(left) == s.charAt(right - 1)) {
            left--;
        }

        while (left == -1 && right < s.length() && s.charAt(left + 1) == s.charAt(right)) {
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {
        P12904_4 T = new P12904_4();
        System.out.println(T.solution("abcdcba")); // 7 홀
        System.out.println(T.solution("abacde")); // 3 짝
        System.out.println(T.solution("abcde")); // 1 홀
        System.out.println(T.solution("abcabcdcbae")); // 7 홀
        System.out.println(T.solution("aaaa")); // 4 짝
        System.out.println(T.solution("a")); // 1 홀
        System.out.println(T.solution("abcbaqwertrewqq")); // 9 홀
        System.out.println(T.solution("abcbaqwqabcba")); // 13 홀
        System.out.println(T.solution("abba")); // 4 짝
        System.out.println(T.solution("abaabaaaaaaa")); // 7 짝
    }

}

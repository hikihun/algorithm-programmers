package Lv0.문자열_겹쳐쓰기;

/**
 * 문자열 겹쳐쓰기
 * ----
 * 문제 설명
 * 문자열 my_string, overwrite_string과 정수 s가 주어집니다. 문자열 my_string의 인덱스 s부터 overwrite_string의 길이만큼을 문자열 overwrite_string으로 바꾼 문자열을 return 하는 solution 함수를 작성해 주세요.
 *
 * 제한사항
 * my_string와 overwrite_string은 숫자와 알파벳으로 이루어져 있습니다.
 * 1 ≤ overwrite_string의 길이 ≤ my_string의 길이 ≤ 1,000
 * 0 ≤ s ≤ my_string의 길이 - overwrite_string의 길이
 *
 * 입출력 예
 * my_string	overwrite_string	s	result
 * "He11oWor1d"	"lloWorl"	2	"HelloWorld"
 * "Program29b8UYP"	"merS123"	7	"ProgrammerS123"
 *
 * 입출력 예 설명
 * 입출력 예 #1
 * 예제 1번의 my_string에서 인덱스 2부터 overwrite_string의 길이만큼에 해당하는 부분은 "11oWor1"이고 이를 "lloWorl"로 바꾼 "HelloWorld"를 return 합니다.
 *
 * 입출력 예 #2
 * 예제 2번의 my_string에서 인덱스 7부터 overwrite_string의 길이만큼에 해당하는 부분은 "29b8UYP"이고 이를 "merS123"로 바꾼 "ProgrammerS123"를 return 합니다.
 */
public class P181943 {

    public String solution(String my_string, String overwrite_string, int s) {


        // 처음 시도한 코드 6번 테스트 실패
//        String substring = my_string.substring(s, s + overwrite_string.length());
//        // 같은 문자열이면 다 변경해버림
//
//        String answer = my_string.replaceFirst(substring, overwrite_string);

        // 풀이 1
//        String answer = my_string.substring(0, s) + overwrite_string;
//        String substring = my_string.substring(s + overwrite_string.length());
//
//        return answer + substring;

        // 풀이 2 통과 시간이 더 빠름, 즉 StringBuilder를 활용하는게 좋다.
        StringBuilder sb = new StringBuilder();
        sb.append(my_string.substring(0, s));
        sb.append(overwrite_string);
        sb.append(my_string.substring(s + overwrite_string.length()));
        return sb.toString();
    }

    public static void main(String[] args) {
        P181943 T = new P181943();
        System.out.println(T.solution("He11oWor1d", "lloWorl", 2));
        System.out.println(T.solution("Program29b8UYP", "merS123", 7));
        System.out.println(T.solution("aaabbaa", "b", 0));
        // 반례

        System.out.println(T.solution("hahahahahahahahha", "youretoslow", 4));

    }

}

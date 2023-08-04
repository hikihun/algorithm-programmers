package Lv1.신규아이디추천;

public class P72410 {

    public String solution(String new_id) {
        String answer = new_id;

        // 1단계
        answer = answer.toLowerCase();

        // 2단계
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
//        System.out.println(answer);

        // 3단계
        answer = answer.replaceAll("[.]+", ".");

//        System.out.println(answer);

        // 4단계
//        answer = answer.replace("[^.]", "");
//        if (answer.charAt(0) == '.') {
//            answer = answer.substring(1);
//        }
//        if (answer.charAt(answer.length() - 1) == '.') {
//            answer = answer.substring(0, answer.length() - 1);
//        }
//        System.out.println(answer.length() - 1);
        answer = answer.replaceAll("^\\.|\\.$", "");
//        System.out.println(answer);

        // 5단계
        if (answer.equals("")) {
            answer = "aaa";
        }

        // 6단계
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15).replaceAll("\\.$", "");
//            if (answer.charAt(answer.length() - 1) == '.') {
//                answer = answer.substring(0, answer.length() - 1);
//            }
        }

        // 7단계
        while (answer.length() <= 2) {
            char c = answer.charAt(answer.length() - 1);
            answer += c;
        }

        return answer;
    }

//    public String solution2(String new_id) {
//        StringBuilder sb = new StringBuilder(new_id);
//
//        sb.
//
//        // 1단계
//        sb = sb.toLowerCase();
//
//        // 2단계
//        sb = sb.replaceAll("[^a-z0-9-_.]", "");
////        System.out.println(answer);
//
//        // 3단계
//        sb = sb.replaceAll("[.]+", ".");
//
////        System.out.println(answer);
//
//        // 4단계
//        sb = sb.replace("[^.]", "");
//        if (sb.charAt(0) == '.') {
//            sb = sb.substring(1);
//        }
//        if (sb.charAt(sb.length() - 1) == '.') {
//            sb = sb.substring(0, sb.length() - 1);
//        }
//        System.out.println(sb.length() - 1);
////        answer = answer.replaceAll("^\\.|\\.$", "");
////        System.out.println(answer);
//
//        // 5단계
//        if (sb.equals("")) {
//            sb = "aaa";
//        }
//
//        // 6단계
//        if (sb.length() >= 16) {
//            sb = sb.substring(0, 15).replaceAll("\\.$", "");
////            if (answer.charAt(answer.length() - 1) == '.') {
////                answer = answer.substring(0, answer.length() - 1);
////            }
//
//        }
//
//        // 7단계
//        while (sb.length() <= 2) {
//            char c = sb.charAt(sb.length() - 1);
//            sb += c;
//        }
//
//        return sb;
//    }

    public static void main(String[] args) {
        P72410 T = new P72410();
        System.out.println(T.solution("...!@BaT#*..y.abcdefghijklm"));
//        System.out.println(T.solution(".."));
        System.out.println(T.solution("z-+.^."));
        System.out.println(T.solution("=.="));
        System.out.println(T.solution(	"123_.def"));
        System.out.println(T.solution("abcdefghijklmn.p"));
    }
}

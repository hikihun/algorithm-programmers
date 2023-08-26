package Lv2.프렌즈4블록;

public class P17679 {

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char [][] checkBoard = new char[m][n];
        char[][] Board = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                checkBoard[i][j] = board[i].charAt(j);
                Board[i][j] = board[i].charAt(j);
//                System.out.print(board[i].charAt(j) + " ");
            }
//            System.out.println();
        }

        while (true) {
            int check = 0;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    int x = j + 1;
                    int y = i + 1;
                    if (checkBoard[i][j] != 'o' && checkBoard[i][j] == checkBoard[i][x]
                        && checkBoard[i][j] == checkBoard[y][j]
                        && checkBoard[i][j] == checkBoard[y][x]) {

                        Board[i][j] = 'x';
                        Board[i][x] = 'x';
                        Board[y][j] = 'x';
                        Board[y][x] = 'x';
                    }
                }
            }
//        for (char[] ca : Board) {
//            for (char c : ca) {
//                System.out.print(c + " ");
//            }
//            System.out.println();
//        }

            // 제거된 블록 수 체크
            for (char[] ca : Board) {
                for (char c : ca) {
                    if (c == 'x') {
                        check++;
                    }
                }
            }

            if (check == 0) {
                break;
            }
            answer += check;

            // 체크보드를 내린걸로 바꿔야함
            for (int i = m-1; i > 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (Board[i][j] == 'x') {
                        for (int k = i - 1; k >= 0; k--) {
                            if (Board[k][j] != 'x') {
                                Board[i][j] = Board[k][j];
                                Board[k][j] = 'x';
                                break;
                            }
                        }

                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (Board[i][j] == 'x') {
                        Board[i][j] = 'o';
                        checkBoard[i][j] = 'o';
                    } else {
                        checkBoard[i][j] = Board[i][j];
                    }
                }
            }

        }


//        for (char[] ca : checkBoard) {
//            for (char c : ca) {
//                System.out.print(c + " ");
//            }
//            System.out.println();
//        }
        System.out.println("=============");

        for (char[] ca : Board) {
            for (char c : ca) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

        System.out.println("=============");
//        for (int i = m - 1; i >= 0; i--) {
//            for (int j = n - 1; j >= 0; j--) {
////                if (Board[i][j] == 'x') {
////                    for (int k = i - 1; k >= 0; k--) {
////                        if (Board[k][j] != 'x') {
////                            Board[i][j] = Board[k][j];
////                            Board[k][j] = 'x';
////                            break;
////                        }
////                    }
////
////                }
//                System.out.print(Board[i][j] + " ");
//            }
//            System.out.println();
//        }


//        for (char[] ca : Board) {
//            for (char c : ca) {
//                System.out.print(c + " ");
//            }
//            System.out.println();
//        }




//        for (char[] ca : checkBoard) {
//            for (char c : ca) {
//                System.out.print(c + " ");
//            }
//            System.out.println();
//        }

        return answer;
    }


    public static void main(String[] args) {
        P17679 T = new P17679();
        System.out.println(T.solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(T.solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
        System.out.println(T.solution(8, 5, new String[]{"HGNHU", "CRSHV", "UKHVL", "MJHQB", "GSHOT", "MQMJJ", "AGJKK", "QULKK"}));
    }
}
